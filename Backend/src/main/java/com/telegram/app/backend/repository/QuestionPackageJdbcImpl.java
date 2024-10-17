package com.telegram.app.backend.repository;

import com.telegram.app.backend.entity.QuestionPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPackageJdbcImpl extends CrudRepository<QuestionPackage,Short> {
}
