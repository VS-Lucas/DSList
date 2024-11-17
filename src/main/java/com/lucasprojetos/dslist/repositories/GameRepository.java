package com.lucasprojetos.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasprojetos.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
