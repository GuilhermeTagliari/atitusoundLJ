package br.edu.atitus.atitusound.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.entities.UserEntity;

@Repository
public interface PlaylistRepository extends GenericRepository<PlaylistEntity>{
	
	Page<List<PlaylistEntity>> findByNameContainingIgnoreCaseAndUserOrPublicshare(Pageable pageable,UserEntity user, boolean publicshare, String name);

}
