package com.telegram.app.backend.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("questions")
@AllArgsConstructor
public class Question {
    @Id
    private Integer id;
    private String content;
    private String tagsJson;
    private short packLevel;

    public List<String> getTags() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(tagsJson, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
