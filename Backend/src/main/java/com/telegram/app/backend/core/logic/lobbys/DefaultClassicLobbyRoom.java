package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.dto.GenerateQuestionDto;
import com.telegram.app.backend.core.logic.players.AbstractPlayer;
import com.telegram.app.backend.core.logic.service.actionService.ClassicActionService;
import com.telegram.app.backend.entity.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class DefaultClassicLobbyRoom extends AbstractLobbyRoom<UUID> {

    private final ClassicActionService actionService;

    private short playerTurnCounter = -1;
    private final short levelFrom;
    private final short levelTo;
    private final short playersAmount;
    private Action lastAction;
    private final List<Short> packages = new ArrayList<>();


    public DefaultClassicLobbyRoom(short levelFrom, short levelTo, ClassicActionService actionService,
                                   List<AbstractPlayer> playerList,List<Short> packages ) {
        super(UUID.randomUUID());
        this.actionService=actionService;
        this.levelFrom = levelFrom;
        this.levelTo = levelTo;
        this.playerList.addAll(playerList);
        this.packages.addAll(packages);
        this.playersAmount = (short) playerList.size();

    }

    @Override
    public Action generateQuestion(GenerateQuestionDto dto) {
        playerTurnCounter++;
        lastAction= actionService.generateClassicAction(levelFrom,levelTo,playerList.get(playerTurnCounter%playersAmount),
                packages,dto.getActionType());
        return lastAction;
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
