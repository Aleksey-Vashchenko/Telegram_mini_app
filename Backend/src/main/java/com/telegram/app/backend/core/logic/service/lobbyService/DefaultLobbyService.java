package com.telegram.app.backend.core.logic.service.lobbyService;

import com.telegram.app.backend.core.logic.lobbys.AbstractLobbyRoom;
import com.telegram.app.backend.core.logic.lobbys.builders.ILobbyRoomBuilder;
import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.entity.Action;

import java.util.UUID;

public class DefaultLobbyService extends AbstractService<UUID, DefaultLobbyDto>{

    @Override
    public UUID createLobby(DefaultLobbyDto dto){
        AbstractLobbyRoom<UUID> lobbyRoom = builder.buildLobbyRoom(dto);
        lobbyMap.put(lobbyRoom.getId(),lobbyRoom);
        return lobbyRoom.getId();
    }

    @Override
    public void deleteLobby(UUID gameId){
        this.lobbyMap.remove(gameId);
    }

    @Override
    public Action getQuestion(UUID gameId) {
        return this.lobbyMap.get(gameId).generateQuestion();
    }

    public DefaultLobbyService(ILobbyRoomBuilder<UUID, DefaultLobbyDto> builder) {
        super(builder);
    }

    public void processQuestion(UUID uuid, Object result) {
        lobbyMap.get(uuid).processAnswer(result);
    }
}
