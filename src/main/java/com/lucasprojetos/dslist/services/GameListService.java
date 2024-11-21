package com.lucasprojetos.dslist.services;

import java.util.List;

import com.lucasprojetos.dslist.dto.GameListDTO;

public interface GameListService {
    public GameListDTO findById(Long id);
    public List<GameListDTO> findAll();
}
