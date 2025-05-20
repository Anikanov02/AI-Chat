package com.anikanov02.selfhost.domain.entity;

import com.anikanov02.selfhost.domain.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chats")
@Getter
@Setter
public class Chat extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 20)
    private String title;
    @Enumerated(EnumType.STRING)
    private Model model;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "chat")
    private List<Message> messages;
}
