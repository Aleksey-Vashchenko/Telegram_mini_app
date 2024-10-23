package com.telegram.app.backend.core.logic.service;

import com.telegram.app.backend.core.logic.lobbys.AbstractLobbyRoom;
import com.telegram.app.backend.core.logic.lobbys.builders.ILobbyRoomBuilder;
import com.telegram.app.backend.core.logic.lobbys.dto.DefaultLobbyDto;
import com.telegram.app.backend.entity.Question;

import java.util.UUID;

public class DefaultLobbyService extends AbstractService<UUID, DefaultLobbyDto>{

    @Override
    public UUID createLobby(DefaultLobbyDto dto){
        AbstractLobbyRoom<UUID> lobbyRoom = builder.buildLobbyRoom(dto);
        lobbyMap.put(lobbyRoom.generateId(),lobbyRoom);
        return lobbyRoom.generateId();
    }

    @Override
    public void deleteLobby(UUID gameId){
        this.lobbyMap.remove(gameId);
    }

    @Override
    public Question getQuestion(UUID gameId) {
        return this.lobbyMap.get(gameId).generateQuestion();
    }

    public DefaultLobbyService(ILobbyRoomBuilder<UUID, DefaultLobbyDto> builder) {
        super(builder);
    }
}
