package com.telegram.app.backend.core.logic.service.lobbyService;

import com.telegram.app.backend.entity.Action;

public interface LobbyService<ID_TYPE,DTO_TYPE> {
    public ID_TYPE createLobby(DTO_TYPE dto);

    public void deleteLobby(ID_TYPE gameId);

    public Action getQuestion(ID_TYPE gameId);

    void processQuestion(ID_TYPE uuid, Object result);
}