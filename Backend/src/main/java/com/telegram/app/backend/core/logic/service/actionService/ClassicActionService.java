package com.telegram.app.backend.core.logic.service.actionService;

import com.telegram.app.backend.core.enums.ActionType;
import com.telegram.app.backend.core.enums.Gender;
import com.telegram.app.backend.core.logic.players.AbstractPlayer;
import com.telegram.app.backend.entity.Action;
import com.telegram.app.backend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
public class ClassicActionService implements ActionService {
    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    public Action generateClassicAction(short levelFrom, short levelTo, AbstractPlayer abstractPlayer, List<Short> packages, ActionType type){
        int choice = random.nextInt(3);
        Set<Gender> doerSet = new HashSet<>();
        doerSet.add(abstractPlayer.getGender());
        doerSet.add(Gender.BOTH);
        Set<Gender> targetSet = new HashSet<>(abstractPlayer.getPreferredGenders());
        targetSet.add(Gender.BOTH);
        return questionRepository.findSingleAction(levelFrom,levelTo,doerSet, targetSet,packages, type).get();
//        switch (choice){
//            //TODO: add processing null result
//            case 0 ->;
////            case 1->questionRepository.findPairedAction(levelFrom,levelTo,abstractPlayer.getPreferredGenders()).get();
//            default -> null;
//        };

        /*{
            "type": "truth/dare",
            "tags": {
                "target": "both",
                "erotic": true/false,
                "doer": "both"
            }
        }*/
    };
}