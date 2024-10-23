package com.telegram.app.backend.web;

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
    private LobbyService<UUID> lobbyService;
    @PostMapping("/{gameId}")
    public Question getQuestion(@PathVariable("gameId")UUID uuid){
        return lobbyService.getQuestion(uuid);
    }

    @PostMapping
    public void createLobby(){
        UUID gameId = lobbyService.createLobby();
    }

    @DeleteMapping("/{gameID}")
    public void deleteLobby(@PathVariable("gameID")UUID gameId){
        lobbyService.deleteLobby(gameId);
    }
}
