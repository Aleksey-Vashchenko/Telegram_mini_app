package com.telegram.app.backend.core.logic.service.actionService;

import com.telegram.app.backend.core.logic.players.AbstractPlayer;
import com.telegram.app.backend.entity.Action;
import com.telegram.app.backend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ClassicActionService implements ActionService {
    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public Action generateClassicAction(short levelFrom, short levelTo, AbstractPlayer abstractPlayer){
        int choice = random.nextInt(3);
         return switch (choice){
            //TODO: add processing null result
            case 0 ->questionRepository.findSingleAction(levelFrom,levelTo).get();
            case 1->questionRepository.findPairedAction(levelFrom,levelTo,abstractPlayer.getPreferredGenders()).get();
            default -> null;
        };

        /*{
            type: "truth/dare",
            tags: {
                target: "men/women/both/none",
                erotic: true/false,

            }
        }*/
    };
}
