package com.telegram.app.backend.core.logic.service;

import com.telegram.app.backend.core.logic.lobbys.ILobby;
import com.telegram.app.backend.core.logic.lobbys.builders.DefaultLobbyRoomBuilder;
import com.telegram.app.backend.core.logic.lobbys.builders.ILobbyRoomBuilder;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractService<ID_TYPE,DTO_TYPE> implements LobbyService<ID_TYPE,DTO_TYPE> {
    protected final Map<ID_TYPE, ILobby<ID_TYPE>> lobbyMap = new HashMap<>();
    protected final ILobbyRoomBuilder<ID_TYPE,DTO_TYPE> builder;

    public AbstractService(ILobbyRoomBuilder<ID_TYPE, DTO_TYPE> builder) {
        this.builder = builder;
    }
}
