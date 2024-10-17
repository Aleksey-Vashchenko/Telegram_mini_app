package com.telegram.app.backend.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "packages")
@AllArgsConstructor
public class QuestionPackage {
    @Id
    private Short id;
    private String name;
    private Float price;
}
