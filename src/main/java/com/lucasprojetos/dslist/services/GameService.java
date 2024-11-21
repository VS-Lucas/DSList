package com.lucasprojetos.dslist.services;

import java.util.List;

import com.lucasprojetos.dslist.dto.GameDTO;
import com.lucasprojetos.dslist.dto.GameMinDTO;

public interface GameService {
    public GameDTO findById(Long id);
    public List<GameMinDTO> findAll();
    public List<GameMinDTO> findByListId(Long listId);
}
