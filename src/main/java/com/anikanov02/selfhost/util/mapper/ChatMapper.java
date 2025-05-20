package com.anikanov02.selfhost.util.mapper;

import com.anikanov02.selfhost.domain.dto.chat.ChatBaseDto;
import com.anikanov02.selfhost.domain.dto.chat.ChatDto;
import com.anikanov02.selfhost.domain.entity.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ChatMapper {
    Chat toEntity(ChatBaseDto dto);
    ChatDto toDto(Chat chat);
    void updateChat(@MappingTarget Chat chat, ChatBaseDto chatBaseDto);
}
