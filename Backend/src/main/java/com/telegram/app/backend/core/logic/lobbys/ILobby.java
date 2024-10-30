package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.entity.Action;

public interface ILobby {
    Action generateQuestion();

    void processAnswer(Object result);
}
