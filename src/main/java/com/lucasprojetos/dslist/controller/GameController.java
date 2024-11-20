package com.lucasprojetos.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasprojetos.dslist.dto.GameDTO;
import com.lucasprojetos.dslist.dto.GameMinDTO;
import com.lucasprojetos.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO game = gameService.findById(id);
        return game;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> games = gameService.findAll();
        return games;
    }
}
 