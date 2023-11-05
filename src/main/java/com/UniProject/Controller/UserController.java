package com.UniProject.Controller;

import com.UniProject.DTO.*;
import com.UniProject.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/message")
    public ResponseEntity<String>showMessage(){
        return ResponseEntity.status(HttpStatus.OK).body("This is for User");
    }

    @GetMapping("/profile")
    public UserDto getUser(HttpServletRequest request){
        String userEmail= (String) request.getAttribute("email");
        return userService.getUser(userEmail);
    }

    @GetMapping("/show-dPlayer")
    public List<PlayerWithoutTeamDto>showDream11Players(HttpServletRequest request){
        String email= (String) request.getAttribute("email");
        return userService.showPlayers(email);
    }
    @GetMapping("/show-Point")
    public UserPlayer showDreamPoint(HttpServletRequest request){
        String email= (String) request.getAttribute("email");
        return userService.showDreamPoint(email);
    }

    @PutMapping("/dPlayer")
    public ResponseEntity<String>addDreamPlayer(@RequestBody UserPlayer player){ // add pid only
        if(userService.addDreamPlayer(player)){
            return ResponseEntity.status(HttpStatus.OK).body("Player added to dream team");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
