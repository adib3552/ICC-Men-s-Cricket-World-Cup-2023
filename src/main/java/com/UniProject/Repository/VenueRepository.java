package com.UniProject.Repository;

import com.UniProject.Enteties.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface VenueRepository extends CrudRepository<Venue,Long> {
    Venue findByName(String name);
}
