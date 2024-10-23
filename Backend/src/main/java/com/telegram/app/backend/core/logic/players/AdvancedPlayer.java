package com.telegram.app.backend.core.logic.players;

import com.telegram.app.backend.core.enums.Gender;

import java.util.Set;

public class AdvancedPlayer extends AbstractPlayer {
    Set<Gender> preferredGenders;
    Short levelFrom;
    Short levelTo;
    Short pairId;
}
