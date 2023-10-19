package com.UniProject.Repository;

import com.UniProject.Enteties.Venue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface VenueRepository extends CrudRepository<Venue,Long> {
    Venue findByName(String name);

    @Modifying
    @Query("update Venue v set v.name=:name where v.vid=:vid")
    void updateVenueName(@Param("name") String name, @Param("vid") long vid);
    @Modifying
    @Query("update Venue v set v.location=:location where v.vid=:vid")
    void updateVenueLocation(@Param("location") String location, @Param("vid") long vid);

    void deleteByVid(long vid);
}
