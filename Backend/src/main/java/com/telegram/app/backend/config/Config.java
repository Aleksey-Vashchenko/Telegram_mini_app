package com.telegram.app.backend.config;

import com.telegram.app.backend.core.enums.ActionType;
import com.telegram.app.backend.core.enums.Gender;
import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.lobbys.builders.DefaultLobbyRoomBuilder;
import com.telegram.app.backend.core.logic.lobbys.builders.ILobbyRoomBuilder;
import com.telegram.app.backend.core.logic.mappers.DefaultAdvancedMapper;
import com.telegram.app.backend.core.logic.mappers.DefaultClassicMapper;
import com.telegram.app.backend.core.logic.service.actionService.ActionService;
import com.telegram.app.backend.core.logic.service.actionService.ClassicActionService;
import com.telegram.app.backend.core.logic.service.lobbyService.DefaultLobbyService;
import com.telegram.app.backend.core.logic.service.lobbyService.LobbyService;
import com.telegram.app.backend.entity.Action;
import com.telegram.app.backend.entity.ActionsPackage;
import com.telegram.app.backend.repository.QuestionPackageRepository;
import com.telegram.app.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.UUID;

@Configuration
public class Config {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionPackageRepository questionPackageRepository;
    @Bean
    public ActionService classicActionService(){
        return new ClassicActionService(questionRepository);
    }
    @Bean
    public ILobbyRoomBuilder<UUID,DefaultLobbyDto> builder(){
        return new DefaultLobbyRoomBuilder(classicMapper(),advancedMapper());

    }

    @Bean
    public LobbyService<UUID,DefaultLobbyDto> lobbyService(){
        return new DefaultLobbyService(builder());
    }

    @Bean
    public DefaultClassicMapper classicMapper(){
        return new DefaultClassicMapper(classicActionService());
    }
    @Bean
    public DefaultAdvancedMapper advancedMapper(){
        return new DefaultAdvancedMapper(classicActionService());
    }

    @EventListener(value = ApplicationStartedEvent.class)
    public void doSmth(){
        ActionsPackage actionsPackage = new ActionsPackage();
        actionsPackage.setName("1");
        actionsPackage.setPrice((float) 1.0);
        questionPackageRepository.save(actionsPackage);
        Action action =new Action();
        action.setDoer(Gender.BOTH);
        action.setTarget(Gender.BOTH);
        action.setActionsPackage(actionsPackage);
        action.setActionType(ActionType.Truth);
        action.setContent("1");
        action.setLevel((short)1);
        action.setActionsPackage(actionsPackage);

        actionsPackage.getActions().add(action);

        questionRepository.save(action);
    }
}
