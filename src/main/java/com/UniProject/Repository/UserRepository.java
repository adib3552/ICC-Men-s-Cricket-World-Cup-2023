package com.UniProject.Repository;

import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    @Query("select u from User u where u.id=:uid")
    User getUserById(@Param("uid") long uid);
    @Query("select u.dreamPoints from User u where u.email=:email")
    int getDreamPoint(@Param("email")String email);
    @Modifying
    @Query("Update User u set u.isEnabled=true where u.email=:email")
    void updateUserEnable(@Param("email") String email);
    @Modifying
    @Query("update User u set u.dreamPoints=:points where u.id=:uid")
    void updateDreamPoints(@Param("points") int points,@Param("uid") long uid);

    @Modifying
    @Query(value = "insert into dream11 (user_id,player_id) values(?2,?1)", nativeQuery = true)
    void addUserDream11(long pid,long uid);
}
