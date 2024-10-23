package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.players.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLobby<ID_TYPE,T extends AbstractPlayer> implements ILobby<ID_TYPE> {
    protected final List<T> playerList = new ArrayList<>();
    protected ID_TYPE id;
}
