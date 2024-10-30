package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.players.AbstractPlayer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
public abstract class AbstractLobbyRoom<ID_TYPE> implements ILobby<ID_TYPE> {
    protected final List<AbstractPlayer> playerList = new ArrayList<>();
    protected ID_TYPE id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAdvancedLobbyRoom lobbyRoom = (DefaultAdvancedLobbyRoom) o;
        return  Objects.equals(id, lobbyRoom.id);
    }

    public void addPlayer(AbstractPlayer player){
        playerList.add(player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    protected AbstractLobbyRoom(ID_TYPE id) {
        this.id = id;
    }
}
