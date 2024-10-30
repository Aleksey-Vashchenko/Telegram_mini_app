package com.telegram.app.backend.core.logic.players;

import com.telegram.app.backend.core.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public abstract class AbstractPlayer {
    Short id;
    String name;
    Gender gender;
    Short score;
    Set<Gender> preferredGenders;
}
