package com.lucasprojetos.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.lucasprojetos.dslist.entities.Game;

public class GameDTO {

	private Long id;
	private String title;
	private Integer year;
	private String genre;
	private String platforms;
    private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;

	public GameDTO() {
    }

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.genre = entity.getGenre();
        this.platforms = entity.getPlatforms();
        this.score = entity.getScore();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
        this.longDescription = entity.getLongDescription();
    }
    
    
}
