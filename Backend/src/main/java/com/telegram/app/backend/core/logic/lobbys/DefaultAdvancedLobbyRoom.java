package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.entity.Question;
import lombok.Setter;

import java.util.UUID;

@Setter
public class DefaultAdvancedLobbyRoom extends AbstractLobbyRoom<UUID>
{

    public DefaultAdvancedLobbyRoom() {
        super(UUID.randomUUID());
    }

    @Override
    public void processAnswer(Object result) {
        //TODO: add logic
    }

    @Override
    public Question generateQuestion() {
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
