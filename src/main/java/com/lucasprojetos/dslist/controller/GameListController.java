package com.lucasprojetos.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasprojetos.dslist.dto.GameListDTO;
import com.lucasprojetos.dslist.dto.GameMinDTO;
import com.lucasprojetos.dslist.response.BuildResponse;
import com.lucasprojetos.dslist.response.Response;
import com.lucasprojetos.dslist.services.GameListService;
import com.lucasprojetos.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @Autowired
    private BuildResponse buildResponse;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<GameListDTO>> findById(@PathVariable Long id) {
        GameListDTO gameListDTO = gameListService.findById(id);

        return buildResponse.build("success", "List found", gameListDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<Response<List<GameMinDTO>>> findByListId(@PathVariable Long listId) {
        List<GameMinDTO> games = gameService.findByListId(listId);
        
        return buildResponse.build("success", "Games found", games, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response<List<GameListDTO>>> findAll() {
        List<GameListDTO> lists = gameListService.findAll();
        
        return buildResponse.build("success", "Lists found", lists, HttpStatus.OK);
    }

}
