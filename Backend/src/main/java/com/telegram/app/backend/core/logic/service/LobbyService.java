package com.telegram.app.backend.core.logic.service;

import com.telegram.app.backend.entity.Question;

public interface LobbyService<ID_TYPE,DTO_TYPE> {
    public ID_TYPE createLobby(DTO_TYPE dto);

    public void deleteLobby(ID_TYPE gameId);

    public Question getQuestion(ID_TYPE gameId);
}