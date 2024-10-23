package com.telegram.app.backend.core.logic.lobbys.builders;


import com.telegram.app.backend.core.logic.lobbys.AbstractLobbyRoom;
import com.telegram.app.backend.core.logic.lobbys.DefaultClassicLobbyRoom;
import com.telegram.app.backend.core.logic.lobbys.dto.DefaultLobbyDto;

import java.util.UUID;

public class DefaultLobbyRoomBuilder implements ILobbyRoomBuilder<UUID, DefaultLobbyDto>{
    @Override
    public AbstractLobbyRoom<UUID> buildLobbyRoom(DefaultLobbyDto dto) {
        //TODO: create dif type of room from dto
        return new DefaultClassicLobbyRoom();
    }
}
