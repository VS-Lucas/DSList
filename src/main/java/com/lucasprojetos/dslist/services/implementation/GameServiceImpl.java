package com.lucasprojetos.dslist.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasprojetos.dslist.dto.GameDTO;
import com.lucasprojetos.dslist.dto.GameMinDTO;
import com.lucasprojetos.dslist.entities.Game;
import com.lucasprojetos.dslist.exceptions.GameNotFoundException;
import com.lucasprojetos.dslist.projections.GameMinProjection;
import com.lucasprojetos.dslist.repositories.GameRepository;
import com.lucasprojetos.dslist.services.GameService;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    @Override
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id)
                                  .orElseThrow(() -> new GameNotFoundException(String.format("Game with id %d not found", id)));
        return new GameDTO(game);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(game -> new GameMinDTO(game)).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<GameMinDTO> findByListId(Long listId) {
        List<GameMinProjection> games = gameRepository.findByListId(listId);

        if (games.isEmpty()) {
            throw new GameNotFoundException(String.format("No games found for list id %d", listId));
        }

        return games.stream().map(game -> new GameMinDTO(game)).toList();
    }
}
