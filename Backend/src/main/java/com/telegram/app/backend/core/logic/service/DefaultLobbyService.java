package com.telegram.app.backend.core.logic.service;

import com.telegram.app.backend.entity.Question;

import java.util.UUID;

public class DefaultLobbyService extends AbstractService<UUID>{

    @Override
    public UUID createLobby(){
        //TODO: add generation logic
        return UUID.randomUUID();
    }

    @Override
    public void deleteLobby(UUID gameId){
        lobbySet.remove(gameId);
    }

    @Override
    public Question getQuestion(UUID gameId) {
        return lobbySet.get(gameId).generateQuestion();
    }
}
