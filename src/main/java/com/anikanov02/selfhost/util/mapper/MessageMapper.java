package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.domain.dto.message.MessageBaseDto;
import com.anikanov02.selfhost.domain.dto.message.MessageDto;
import com.anikanov02.selfhost.domain.entity.Chat;
import com.anikanov02.selfhost.domain.entity.Message;
import org.mapstruct.Mapper;

@Mapper
public interface MessageMapper {
    Message toEntity(MessageBaseDto dto, Chat chat);
    MessageDto toDto(Message message);
    void updateMessage(Message message, MessageBaseDto messageBaseDto);
}
