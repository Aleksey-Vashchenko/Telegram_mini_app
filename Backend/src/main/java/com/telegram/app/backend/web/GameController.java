package com.telegram.app.backend.web;

import com.telegram.app.backend.core.logic.lobbys.builders.ILobbyRoomBuilder;
import com.telegram.app.backend.core.logic.lobbys.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.service.LobbyService;
import com.telegram.app.backend.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/games")
public class GameController {
    private LobbyService<UUID, DefaultLobbyDto> lobbyService;
    @PostMapping("/{gameId}")
    public Question getQuestion(@PathVariable("gameId")UUID uuid){
        return lobbyService.getQuestion(uuid);
    }

    @PostMapping
    public Object createLobby(@RequestBody DefaultLobbyDto dto){
        return lobbyService.createLobby(dto);
    }

    @DeleteMapping("/{gameID}")
    public void deleteLobby(@PathVariable("gameID")UUID gameId){
        lobbyService.deleteLobby(gameId);
    }
}
