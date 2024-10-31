package com.telegram.app.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "packages")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = {"userList","actions"})
public class ActionsPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String name;
    private Float price;
    @JsonIgnore
    @ManyToMany(mappedBy = "packages")
    private List<User> userList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "actionsPackage")
    private List<Action> actions = new ArrayList<>();
}
