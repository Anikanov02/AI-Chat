package com.anikanov02.selfhost.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "first_name", length = 40)
    private String firstName;
    @Column(name = "last_name", length = 40)
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Chat> chats;
}
