package com.telegram.app.backend.repository;

import com.telegram.app.backend.entity.QuestionPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionPackageRepository extends JpaRepository<QuestionPackage,Short> {
    @Query("SELECT p FROM QuestionPackage p JOIN p.userList u WHERE u.uuid = :userId")
    List<QuestionPackage> findPackagesByUserId(String userId);
}
