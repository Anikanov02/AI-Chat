package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.dto.ChatDto;
import com.anikanov02.selfhost.model.Chat;
import org.mapstruct.Mapper;

@Mapper
public interface ChatMapper {
    Chat toEntity(ChatDto dto);
    ChatDto toDto(Chat chat);
}
