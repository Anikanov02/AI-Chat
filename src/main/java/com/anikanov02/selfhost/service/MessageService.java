package com.anikanov02.selfhost.service;

import com.anikanov02.selfhost.domain.Model;
import com.anikanov02.selfhost.domain.dto.message.MessageBaseDto;
import com.anikanov02.selfhost.domain.dto.message.MessageDto;
import com.anikanov02.selfhost.domain.dto.message.MessagesPaginatedRequest;
import com.anikanov02.selfhost.domain.dto.model.ModelRequest;
import com.anikanov02.selfhost.domain.entity.Chat;
import com.anikanov02.selfhost.domain.entity.Message;
import com.anikanov02.selfhost.repository.MessageRepository;
import com.anikanov02.selfhost.util.mapper.MessageMapper;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final ChatService chatService;
    private final ModelCommunicationService communicationService;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public Message getById(UUID uuid) {
        return messageRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cant find message with id: " + uuid));
    }

    public Page<MessageDto> getMessages(MessagesPaginatedRequest request) {
        final PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize(), Sort.by("createdAt").ascending());

        final Specification<Message> spec = (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (request.getChatId() != null) {
                final Join<Message, Chat> chatJoin = root.join("chat");
                predicate = cb.and(predicate, cb.equal(chatJoin.get("id"), request.getChatId()));
            }

            return predicate;
        };

        return messageRepository.findAll(spec, pageRequest).map(messageMapper::toDto);
    }

    public MessageDto getMessage(UUID uuid) {
        return messageMapper.toDto(getById(uuid));
    }

    @Transactional
    public MessageDto createMessage(MessageBaseDto dto, UUID chatId) {
        final Chat chat = chatService.getById(chatId);
        messageRepository.save(messageMapper.toEntity(dto, chat, chat.getUser()));

        final MessageBaseDto responseDto = generateResponse(dto.getText(), chat.getModel(), chatId);
        final Message savedResponse = messageRepository.save(messageMapper.toEntity(responseDto, chat, null));
        return messageMapper.toDto(savedResponse);
    }

    @Transactional
    public MessageDto updateMessage(UUID id, MessageBaseDto dto) {
        final Message message = getById(id);
        messageMapper.updateMessage(getById(id), dto);
        return messageMapper.toDto(messageRepository.save(message));
    }

    public void deleteMessage(UUID id) {
        messageRepository.deleteById(id);
    }

    private MessageBaseDto generateResponse(String request, Model model, UUID chatId) {
        return new MessageBaseDto(communicationService.getResponse(ModelRequest
                .builder()
                        .input(request)
                        .chatId(chatId)
                        .model(model)
                .build())
                .getText());
    }
}
