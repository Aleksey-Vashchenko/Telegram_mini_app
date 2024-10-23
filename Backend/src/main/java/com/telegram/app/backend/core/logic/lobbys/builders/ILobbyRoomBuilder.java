package com.telegram.app.backend.core.logic.lobbys.builders;

import com.telegram.app.backend.core.logic.lobbys.AbstractLobbyRoom;

public interface ILobbyRoomBuilder<ID_TYPE,T> {
    AbstractLobbyRoom<ID_TYPE> buildLobbyRoom(T dto);
}
