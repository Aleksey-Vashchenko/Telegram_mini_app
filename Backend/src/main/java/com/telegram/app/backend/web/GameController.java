package com.telegram.app.backend.web;

import com.telegram.app.backend.core.logic.dto.DefaultLobbyDto;
import com.telegram.app.backend.core.logic.dto.GenerateQuestionDto;
import com.telegram.app.backend.core.logic.dto.response.MapResponse;
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
    public MapResponse getQuestion(@PathVariable("gameId")UUID uuid, @RequestBody GenerateQuestionDto dto){
        Action action = lobbyService.getQuestion(uuid,dto);
        MapResponse mapResponse = new MapResponse();
        mapResponse.addData("action",action);
        return mapResponse;
    }
    @PostMapping("/{gameId}/questions/process")
    public void processQuestion(@PathVariable("gameId")UUID uuid, @RequestBody Object result){
        lobbyService.processQuestion(uuid,result);
    }

    @PostMapping
    public MapResponse createLobby(@RequestBody DefaultLobbyDto dto){
        MapResponse mapResponse = new MapResponse();
        mapResponse.addData("uuid",lobbyService.createLobby(dto));
        return mapResponse;
    }

    @DeleteMapping("/{gameID}")
    public void deleteLobby(@PathVariable("gameID")UUID gameId){
        lobbyService.deleteLobby(gameId);
    }
}
