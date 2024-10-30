package com.telegram.app.backend.core.logic.mappers;


import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.dto.DefaultPlayerDto;
import com.telegram.app.backend.core.logic.lobbys.DefaultClassicLobbyRoom;
import com.telegram.app.backend.core.logic.players.ClassicPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public abstract class DefaultClassicMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "playerList", ignore = true)
    public abstract DefaultClassicLobbyRoom mapToClassicLobbyRoom(DefaultLobbyDto lobbyDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "gender", target = "gender")
    protected abstract ClassicPlayer mapToAbstractPlayer(DefaultPlayerDto playerDto);

    public abstract List<ClassicPlayer> mapToListOfClassicPlayers(List<DefaultPlayerDto> defaultPlayerDtos);
}
