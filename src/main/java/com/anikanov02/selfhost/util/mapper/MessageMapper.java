package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.dto.message.MessageDto;
import com.anikanov02.selfhost.model.Message;
import org.mapstruct.Mapper;

@Mapper
public interface MessageMapper {
    Message toEntity(MessageDto dto);
    MessageDto toDto(Message message);
}
