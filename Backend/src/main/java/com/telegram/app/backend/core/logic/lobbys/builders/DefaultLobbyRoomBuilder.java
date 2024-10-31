package com.telegram.app.backend.core.logic.lobbys.builders;


import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.lobbys.AbstractLobbyRoom;
import com.telegram.app.backend.core.logic.lobbys.DefaultClassicLobbyRoom;
import com.telegram.app.backend.core.logic.mappers.DefaultAdvancedMapper;
import com.telegram.app.backend.core.logic.mappers.DefaultClassicMapper;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DefaultLobbyRoomBuilder implements ILobbyRoomBuilder<UUID, DefaultLobbyDto>{
    private final DefaultClassicMapper classicMapper;
    private final DefaultAdvancedMapper advancedMapper;
    @Override
    public AbstractLobbyRoom<UUID> buildLobbyRoom(DefaultLobbyDto dto) {
        return switch (dto.getGameType()) {
            case CLASSIC -> buildDefaultClassicLobbyRoom(dto);
//            case ADVANCED -> buildDefaultAdvancedLobbyRoom(dto);
            default -> {
                //TODO: add logger and advice handler
                throw new IllegalArgumentException();
            }
        };
    }

    private DefaultClassicLobbyRoom buildDefaultClassicLobbyRoom(DefaultLobbyDto dto){
        return classicMapper.mapToClassicLobbyRoom(dto);
    }
//    private DefaultAdvancedLobbyRoom buildDefaultAdvancedLobbyRoom(DefaultLobbyDto dto){
//        DefaultAdvancedLobbyRoom lobbyRoom = advancedMapper.mapToAdvancedLobbyRoom(dto);
//        List<AdvancedPlayer> playerList = advancedMapper.mapToListOfAdvancedPlayers(dto.getPlayers());
//        playerList.sort(Comparator.comparing(AbstractPlayer::getId));
//        for (AdvancedPlayer advancedPlayer : playerList) {
//            lobbyRoom.addPlayer(advancedPlayer);
//        }
//        return lobbyRoom;
//    }

}
