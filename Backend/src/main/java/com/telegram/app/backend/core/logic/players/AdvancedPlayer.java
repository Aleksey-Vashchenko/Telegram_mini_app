package com.telegram.app.backend.core.logic.players;

import com.telegram.app.backend.core.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AdvancedPlayer extends AbstractPlayer {
    Set<Gender> preferredGenders;
    Short levelFrom;
    Short levelTo;
    Short pairId;
}
