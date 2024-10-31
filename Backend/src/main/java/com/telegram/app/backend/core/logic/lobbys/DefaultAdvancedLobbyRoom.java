package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.dto.GenerateQuestionDto;
import com.telegram.app.backend.entity.Action;
import com.telegram.app.backend.core.logic.service.actionService.ActionService;
import lombok.Setter;

import java.util.UUID;

@Setter
public class DefaultAdvancedLobbyRoom extends AbstractLobbyRoom<UUID>
{
    //TODO: edit constructor and mapper
    private final ActionService actionService;

    public DefaultAdvancedLobbyRoom(ActionService actionService) {
        super(UUID.randomUUID());
        this.actionService = actionService;

    }

    @Override
    public void processAnswer(Object result) {
        //TODO: add logic
    }

    @Override
    public Action generateQuestion(GenerateQuestionDto dto) {
        //TODO: add logic for advanced
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
