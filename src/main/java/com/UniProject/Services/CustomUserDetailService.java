package com.UniProject.Services;

import com.UniProject.Enteties.CustomUserDetails;
import com.UniProject.Enteties.User;
import com.UniProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepository.findByEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("Email not found");
        }

        CustomUserDetails customUserDetails=new CustomUserDetails(user);

        return customUserDetails;
    }
}
