package br.edu.atitus.atitusound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.atitusound.dtos.MusicDTO;
import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.entities.MusicEntity;
import br.edu.atitus.atitusound.services.GenericService;
import br.edu.atitus.atitusound.services.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController extends GenericController<MusicEntity, MusicDTO>{

	private final MusicService musicService;
	
	public MusicController(MusicService musicService) {
		super();
		this.musicService = musicService;
	}

	@Override
	public GenericService<MusicEntity> getService() {
		return musicService;
	}

	@Override
	protected MusicEntity convertDTO2Entity(MusicDTO dto) {
		MusicEntity music = new MusicEntity();
		music.setName(dto.getName());
		music.setDuration(dto.getDuration());
		music.setUrl(dto.getUrl());
		
		ArtistEntity artist = new ArtistEntity();
		artist.setUuid(dto.getArtist().getUuid());
		
		music.setArtist(artist);
		return music;
	}

}
