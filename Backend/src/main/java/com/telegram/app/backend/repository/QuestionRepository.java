package com.telegram.app.backend.repository;

import com.telegram.app.backend.entity.Question;
import com.telegram.app.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Integer> {
}
