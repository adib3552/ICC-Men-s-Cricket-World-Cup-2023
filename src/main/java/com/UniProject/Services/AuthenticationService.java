package com.UniProject.Services;

import com.UniProject.DTO.JwtResponse;
import com.UniProject.DTO.RefreshToken;
import com.UniProject.DTO.SignInRequest;
import com.UniProject.Enteties.User;
import com.UniProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class AuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailService userService;

    public JwtResponse login(SignInRequest signInRequest){

        User user=userRepository.findByEmailAndPassword(signInRequest.getEmail(), signInRequest.getPassword());

        if(user==null){
            throw new IllegalArgumentException("Wrong username or Password");
        }

        UserDetails userDetails=userService.loadUserByUsername(signInRequest.getEmail());

        System.out.println(userDetails);
        JwtResponse jwtResponse=new JwtResponse();
        jwtResponse.setToken(jwtService.generateToken(userDetails));
        jwtResponse.setRefreshToken(jwtService.generateRefreshedToken(new HashMap<>(),userDetails));

        return jwtResponse;
    }
    public JwtResponse refreshToken(RefreshToken token){
        String username=jwtService.extractUsername(token.getRefreshToken());
        System.out.println(token.getRefreshToken()+" "+username);
        UserDetails user=userService.loadUserByUsername(username);
        if(user==null){
            throw new IllegalArgumentException("Email not found");
        }
        if(jwtService.isTokenValid(token.getRefreshToken(),user)){
            String jwt=jwtService.generateToken(user);
            String refreshToken=jwtService.generateRefreshedToken(new HashMap<>(),user);

            JwtResponse jwtResponse=new JwtResponse();

            jwtResponse.setToken(jwt);
            jwtResponse.setRefreshToken(refreshToken);
            return jwtResponse;
        }
        return null;
    }
}
