package com.telegram.app.backend.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table(name = "players")
@AllArgsConstructor
public class User {
    @Id
    private UUID uuid;
    private String userName;
    private List<Short> packages;
}
