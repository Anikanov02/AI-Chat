package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.domain.dto.message.MessageBaseDto;
import com.anikanov02.selfhost.domain.dto.message.MessageDto;
import com.anikanov02.selfhost.domain.entity.Chat;
import com.anikanov02.selfhost.domain.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface MessageMapper {
    @Mapping(target = "chat", source = "chat")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    Message toEntity(MessageBaseDto dto, Chat chat);
    MessageDto toDto(Message message);
    void updateMessage(@MappingTarget Message message, MessageBaseDto messageBaseDto);
}
