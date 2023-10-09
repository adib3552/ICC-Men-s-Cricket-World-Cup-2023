package com.UniProject.Repository;

import com.UniProject.Enteties.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlayerRepository extends CrudRepository<Player,Long> {
    Player findByName(String name);
}
