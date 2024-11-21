package com.lucasprojetos.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasprojetos.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}