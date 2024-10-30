package com.telegram.app.backend.repository;

import com.telegram.app.backend.entity.ActionsPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionPackageRepository extends JpaRepository<ActionsPackage,Short> {
    @Query("SELECT p FROM ActionsPackage p JOIN p.userList u WHERE u.uuid = :userId")
    List<ActionsPackage> findPackagesByUserId(String userId);
}
