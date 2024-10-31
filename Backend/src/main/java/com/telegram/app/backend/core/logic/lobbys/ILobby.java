package com.telegram.app.backend.core.logic.lobbys;

import com.telegram.app.backend.core.logic.dto.GenerateQuestionDto;
import com.telegram.app.backend.entity.Action;

public interface ILobby {
    Action generateQuestion(GenerateQuestionDto o);

    void processAnswer(Object result);
}
