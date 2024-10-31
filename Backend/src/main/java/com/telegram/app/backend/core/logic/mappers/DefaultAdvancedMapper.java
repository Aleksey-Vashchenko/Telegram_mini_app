package com.telegram.app.backend.core.logic.mappers;


import com.telegram.app.backend.core.enums.Gender;
import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.dto.DefaultPlayerDto;
import com.telegram.app.backend.core.logic.lobbys.DefaultAdvancedLobbyRoom;
import com.telegram.app.backend.core.logic.players.AdvancedPlayer;
import com.telegram.app.backend.core.logic.service.actionService.ActionService;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class DefaultAdvancedMapper {

    private final ActionService actionService;

    public DefaultAdvancedMapper(@Qualifier("advancedActionService") ActionService actionService) {
        this.actionService = actionService;
    }

    public DefaultAdvancedLobbyRoom mapToAdvancedLobbyRoom(DefaultLobbyDto lobbyDto) {
        if ( lobbyDto == null ) {
            return null;
        }

        ActionService actionService = null;

        DefaultAdvancedLobbyRoom defaultAdvancedLobbyRoom = new DefaultAdvancedLobbyRoom( actionService );

        return defaultAdvancedLobbyRoom;
    }

    protected AdvancedPlayer mapToAdvancedPlayer(DefaultPlayerDto playerDto) {
        if ( playerDto == null ) {
            return null;
        }

        AdvancedPlayer advancedPlayer = new AdvancedPlayer();

        if ( playerDto.getId() != null ) {
            advancedPlayer.setId( playerDto.getId().shortValue() );
        }
        advancedPlayer.setName( playerDto.getName() );
        advancedPlayer.setGender( playerDto.getGender() );
        List<Gender> list = playerDto.getPreferredGenders();
        if ( list != null ) {
            advancedPlayer.setPreferredGenders( new LinkedHashSet<Gender>( list ) );
        }
        advancedPlayer.setLevelFrom( playerDto.getLevelFrom() );
        advancedPlayer.setLevelTo( playerDto.getLevelTo() );
        advancedPlayer.setPairId( playerDto.getPairId() );

        return advancedPlayer;
    }

    public List<AdvancedPlayer> mapToListOfAdvancedPlayers(List<DefaultPlayerDto> defaultPlayerDtos) {
        if ( defaultPlayerDtos == null ) {
            return null;
        }

        List<AdvancedPlayer> list = new ArrayList<AdvancedPlayer>( defaultPlayerDtos.size() );
        for ( DefaultPlayerDto defaultPlayerDto : defaultPlayerDtos ) {
            list.add( mapToAdvancedPlayer( defaultPlayerDto ) );
        }

        return list;
    }
}
