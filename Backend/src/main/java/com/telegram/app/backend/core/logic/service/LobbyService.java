package com.telegram.app.backend.core.logic.service;

import com.telegram.app.backend.entity.Question;

public interface LobbyService<ID_TYPE> {
    public ID_TYPE createLobby();

    public void deleteLobby(ID_TYPE gameId);

    public Question getQuestion(ID_TYPE gameId);
}