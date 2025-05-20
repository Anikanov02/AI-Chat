package com.anikanov02.selfhost.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message extends BaseEntity {
    private UUID id;
    @Column(length = 5000)
    private String text;
    @ManyToOne
    private User user;
    @ManyToOne
    private Chat chat;
}
