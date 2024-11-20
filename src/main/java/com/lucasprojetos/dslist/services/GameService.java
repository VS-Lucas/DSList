package com.lucasprojetos.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasprojetos.dslist.dto.GameDTO;
import com.lucasprojetos.dslist.dto.GameMinDTO;
import com.lucasprojetos.dslist.entities.Game;
import com.lucasprojetos.dslist.exceptions.GameNotFoundException;
import com.lucasprojetos.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                                  .orElseThrow(() -> new GameNotFoundException(String.format("Game with id %d not found", id)));
        return new GameDTO(game);
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(game -> new GameMinDTO(game)).toList();
    }
}
