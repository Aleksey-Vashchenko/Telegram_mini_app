package com.telegram.app.backend.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "questions")
@Entity
public class Question {
    @Id
    private Integer id;
    private String content;
    private String tagsJson;
    @ManyToOne
    @JoinColumn(name = "package_id")
    private QuestionPackage questionPackage;

    public List<String> getTags() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(tagsJson, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
