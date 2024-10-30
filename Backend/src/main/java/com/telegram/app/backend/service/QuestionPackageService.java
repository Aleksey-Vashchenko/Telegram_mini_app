package com.telegram.app.backend.service;

import com.telegram.app.backend.entity.ActionsPackage;
import com.telegram.app.backend.repository.QuestionPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionPackageService {
    private final QuestionPackageRepository repository;

    public List<ActionsPackage> findPackagesByUser(String userId) {
        return repository.findPackagesByUserId(userId);
    }

    public List<ActionsPackage> findAll() {
        return repository.findAll();
    }
}
