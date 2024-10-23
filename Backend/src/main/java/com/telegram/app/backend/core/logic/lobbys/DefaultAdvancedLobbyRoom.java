package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.players.AdvancedPlayer;
import com.telegram.app.backend.entity.Question;

import java.util.UUID;

public class DefaultAdvancedLobbyRoom extends AbstractLobbyRoom<UUID>
{

    @Override
    public Question generateQuestion() {
        return null;
    }

    @Override
    public UUID generateId() {
        if(this.id==null){
            this.id=UUID.randomUUID();
        }
        return this.id;
    }
}
