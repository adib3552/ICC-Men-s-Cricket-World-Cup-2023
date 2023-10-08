package com.UniProject.Repository;

import com.UniProject.Enteties.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    @Modifying
    @Query("Update User u set u.isEnabled=true where u.email=:email")
    void updateUserEnable(@Param("email") String email);
}
