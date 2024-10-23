package com.telegram.app.backend.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "packages")
@Entity
public class QuestionPackage {
    @Id
    private Short id;
    private String name;
    private Float price;
    @ManyToMany(mappedBy = "packages")
    private List<User> userList;
    @OneToMany(mappedBy = "questionPackage")
    private List<Question> questions;
}
