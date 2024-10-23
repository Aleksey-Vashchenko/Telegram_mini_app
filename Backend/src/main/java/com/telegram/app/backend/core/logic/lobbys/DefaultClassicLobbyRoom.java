package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.players.ClassicPlayer;
import com.telegram.app.backend.entity.Question;

import java.util.UUID;

public class DefaultClassicLobbyRoom extends AbstractLobby<UUID,ClassicPlayer> {
    @Override
    public Question generateQuestion() {
        return null;
    }

    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
