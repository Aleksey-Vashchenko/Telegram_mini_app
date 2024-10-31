package com.telegram.app.backend.core.logic.mappers;


import com.telegram.app.backend.core.enums.Gender;
import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.dto.DefaultPlayerDto;
import com.telegram.app.backend.core.logic.lobbys.DefaultClassicLobbyRoom;
import com.telegram.app.backend.core.logic.players.AbstractPlayer;
import com.telegram.app.backend.core.logic.players.ClassicPlayer;
import com.telegram.app.backend.core.logic.service.actionService.ActionService;
import com.telegram.app.backend.core.logic.service.actionService.ClassicActionService;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

public class DefaultClassicMapper {

    private final ActionService actionService;

    public DefaultClassicMapper(@Qualifier("classicActionService") ActionService actionService) {
        this.actionService = actionService;
    }

    public DefaultClassicLobbyRoom mapToClassicLobbyRoom(DefaultLobbyDto lobbyDto) {
        if ( lobbyDto == null ) {
            return null;
        }

        short levelFrom = lobbyDto.getDifficultyFrom();
        short levelTo = lobbyDto.getDifficultyFrom();
        List<Short> packages = lobbyDto.getPackages();
        List<AbstractPlayer> playerList = mapToListOfClassicPlayers(lobbyDto.getPlayers());
        playerList.sort(Comparator.comparing(AbstractPlayer::getId));
        return new DefaultClassicLobbyRoom(levelFrom,levelTo,(ClassicActionService) actionService,
                playerList,packages);
    }

    protected AbstractPlayer mapToAbstractPlayer(DefaultPlayerDto playerDto) {
        if ( playerDto == null ) {
            return null;
        }

        ClassicPlayer classicPlayer = new ClassicPlayer();

        if ( playerDto.getId() != null ) {
            classicPlayer.setId( playerDto.getId().shortValue() );
        }
        classicPlayer.setName( playerDto.getName() );
        classicPlayer.setGender( playerDto.getGender() );
        List<Gender> list = playerDto.getPreferredGenders();
        if ( list != null ) {
            classicPlayer.setPreferredGenders( new LinkedHashSet<Gender>( list ) );
        }

        return classicPlayer;
    }
    protected List<AbstractPlayer> mapToListOfClassicPlayers(List<DefaultPlayerDto> defaultPlayerDtos) {
        if ( defaultPlayerDtos == null ) {
            return null;
        }

        List<AbstractPlayer> list = new ArrayList<AbstractPlayer>( defaultPlayerDtos.size() );
        for ( DefaultPlayerDto defaultPlayerDto : defaultPlayerDtos ) {
            list.add( mapToAbstractPlayer( defaultPlayerDto ) );
        }

        return list;
    }
}
