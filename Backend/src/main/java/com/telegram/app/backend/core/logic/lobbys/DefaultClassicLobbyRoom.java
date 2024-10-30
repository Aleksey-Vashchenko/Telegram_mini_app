package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.service.actionService.ActionService;
import com.telegram.app.backend.core.logic.service.actionService.ClassicActionService;
import com.telegram.app.backend.entity.Action;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class DefaultClassicLobbyRoom extends AbstractLobbyRoom<UUID> {

    private final ClassicActionService actionService;

    private short playerTurnCounter = -1;
    private final short levelFrom;
    private final short levelTo;


    public DefaultClassicLobbyRoom(short levelFrom, short levelTo, ClassicActionService actionService) {
        super(UUID.randomUUID());
        this.actionService=actionService;
        this.levelFrom = levelFrom;
        this.levelTo = levelTo;
    }

    @Override
    public Action generateQuestion() {
        playerTurnCounter++;
        //TODO: add logic to generate questions
        return actionService.generateClassicAction(levelFrom,levelTo,playerList.get(playerTurnCounter));
    }

    @Override
    public void processAnswer(Object result) {
//TODO: add logic
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
