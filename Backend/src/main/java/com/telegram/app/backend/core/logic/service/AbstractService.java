package com.telegram.app.backend.core.logic.service;

import com.telegram.app.backend.core.logic.lobbys.ILobby;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractService<ID_TYPE> implements LobbyService<ID_TYPE> {
    protected final Map<ID_TYPE, ILobby<ID_TYPE>> lobbySet = new HashMap<>();
}
