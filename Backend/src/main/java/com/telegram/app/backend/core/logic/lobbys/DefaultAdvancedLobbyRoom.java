package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.entity.Question;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAdvancedLobbyRoom lobbyRoom = (DefaultAdvancedLobbyRoom) o;
        return  Objects.equals(id, lobbyRoom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
