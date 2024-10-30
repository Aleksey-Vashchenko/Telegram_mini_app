package com.telegram.app.backend.web;

import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.service.lobbyService.LobbyService;
import com.telegram.app.backend.entity.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/games")
public class GameController {
    private final LobbyService<UUID, DefaultLobbyDto> lobbyService;
    @PostMapping("/{gameId}/questions")
    public Action getQuestion(@PathVariable("gameId")UUID uuid){
        return lobbyService.getQuestion(uuid);
    }
    @PostMapping("/{gameId}/questions/process")
    public void processQuestion(@PathVariable("gameId")UUID uuid, @RequestBody Object result){
        lobbyService.processQuestion(uuid,result);
    }

    @PostMapping
    public ResponseEntity<UUID> createLobby(@RequestBody DefaultLobbyDto dto){
        return new ResponseEntity<>(lobbyService.createLobby(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{gameID}")
    public void deleteLobby(@PathVariable("gameID")UUID gameId){
        lobbyService.deleteLobby(gameId);
    }
}
