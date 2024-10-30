package com.telegram.app.backend.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Table(name = "players")
@Entity
public class User {
    @Id
    private UUID uuid;
    private String userName;
    @ManyToMany
    @JoinTable(
            name = "users_packages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id")
    )
    private List<ActionsPackage> packages;
}
