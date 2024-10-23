package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.players.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLobbyRoom<ID_TYPE> implements ILobby<ID_TYPE> {
    protected final List<? extends AbstractPlayer> playerList = new ArrayList<>();
    protected ID_TYPE id;
}
