package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.players.AbstractPlayer;
import com.telegram.app.backend.core.logic.players.ClassicPlayer;
import com.telegram.app.backend.entity.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class DefaultClassicLobbyRoom extends AbstractLobbyRoom<UUID> {


    private final short playerTurnCounter = 0;
    public DefaultClassicLobbyRoom() {
        super(UUID.randomUUID());
    }

    @Override
    public Question generateQuestion() {
        //TODO: add logic to generate questions
        return null;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
