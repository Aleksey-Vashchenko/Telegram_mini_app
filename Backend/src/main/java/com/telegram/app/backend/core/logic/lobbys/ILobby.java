package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.entity.Question;

public interface ILobby<ID_TYPE> {
    Question generateQuestion();
}
