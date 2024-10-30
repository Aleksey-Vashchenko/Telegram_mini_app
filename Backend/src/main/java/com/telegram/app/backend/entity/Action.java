package com.telegram.app.backend.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telegram.app.backend.core.enums.ActionType;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "actions")
@Entity
public class Action {
    @Id
    private Integer id;
    private String content;

    private Short level;
    private String tagsJson;
    @ManyToOne
    @JoinColumn(name = "package_id")
    private ActionsPackage actionsPackage;
}
