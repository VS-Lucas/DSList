package com.lucasprojetos.dslist.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasprojetos.dslist.dto.GameListDTO;
import com.lucasprojetos.dslist.entities.GameList;
import com.lucasprojetos.dslist.exceptions.GameListNotFoundException;
import com.lucasprojetos.dslist.repositories.GameListRepository;
import com.lucasprojetos.dslist.services.GameListService;

@Service
public class GameListServiceImpl implements GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    @Override
    public GameListDTO findById(Long id) {
        GameList list = gameListRepository.findById(id)
                                  .orElseThrow(() -> new GameListNotFoundException(String.format("Game list with id %d not found", id)));
        return new GameListDTO(list);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<GameListDTO> findAll() {
        List<GameList> lists = gameListRepository.findAll();
        return lists.stream().map(game -> new GameListDTO(game)).toList();
    }
}
