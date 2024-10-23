package com.telegram.app.backend.core.logic.lobbys.builders;


import com.telegram.app.backend.core.logic.lobbys.AbstractLobbyRoom;

import java.util.UUID;

public class DefaultLobbyRoomBuilder implements ILobbyRoomBuilder<UUID,Object>{
    @Override
    public AbstractLobbyRoom<UUID> buildLobbyRoom(Object dto) {
        return null;
    }
}
