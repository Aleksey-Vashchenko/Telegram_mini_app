package com.telegram.app.backend.core.logic.mappers;


import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.dto.DefaultPlayerDto;
import com.telegram.app.backend.core.logic.lobbys.DefaultAdvancedLobbyRoom;
import com.telegram.app.backend.core.logic.players.AdvancedPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public abstract class DefaultAdvancedMapper {

    @Mapping(target = "id", ignore = true)
    public abstract DefaultAdvancedLobbyRoom mapToAdvancedLobbyRoom(DefaultLobbyDto lobbyDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    protected abstract AdvancedPlayer mapToAdvancedPlayer(DefaultPlayerDto playerDto);

    public abstract List<AdvancedPlayer> mapToListOfAdvancedPlayers(List<DefaultPlayerDto> defaultPlayerDtos);
}
