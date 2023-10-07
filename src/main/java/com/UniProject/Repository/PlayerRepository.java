package com.UniProject.Repository;

import com.UniProject.Entities.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlayerRepository extends CrudRepository<Player,Long> {
}
