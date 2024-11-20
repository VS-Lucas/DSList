package com.lucasprojetos.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasprojetos.dslist.dto.GameDTO;
import com.lucasprojetos.dslist.dto.GameMinDTO;
import com.lucasprojetos.dslist.response.BuildResponse;
import com.lucasprojetos.dslist.response.Response;
import com.lucasprojetos.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private BuildResponse buildResponse;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<GameDTO>> findById(@PathVariable Long id) {
        GameDTO gameDTO = gameService.findById(id);

        return buildResponse.build("success", "Game found", gameDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response<List<GameMinDTO>>> findAll() {
        List<GameMinDTO> games = gameService.findAll();
        
        return buildResponse.build("success", "Games found", games, HttpStatus.OK);
    }
}
