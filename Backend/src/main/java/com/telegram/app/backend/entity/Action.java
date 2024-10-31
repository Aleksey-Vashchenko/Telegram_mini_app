package com.telegram.app.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telegram.app.backend.core.enums.ActionType;
import com.telegram.app.backend.core.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "actions")
@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "actionsPackage")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @Enumerated(EnumType.STRING)
    private Gender target;
    @Enumerated(EnumType.STRING)
    private Gender doer;
    private boolean isSexual;
    @Enumerated(EnumType.STRING)
    private ActionType actionType;
    private Short level;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "package_id")
    private ActionsPackage actionsPackage;
}
