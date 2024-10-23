package com.telegram.app.backend.web;

import com.telegram.app.backend.entity.QuestionPackage;
import com.telegram.app.backend.service.QuestionPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/packages")
public class PackagesController {
    private final QuestionPackageService questionPackageService;

    @GetMapping("/{userId}")
    public List<QuestionPackage> getPackages(@PathVariable("userId")String userId){
        return  questionPackageService.findPackagesByUser(userId);
    }

    @GetMapping
    public List<QuestionPackage> getAll(){
        return  questionPackageService.findAll();
    }
}
