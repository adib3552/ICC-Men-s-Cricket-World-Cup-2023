package com.UniProject.Controller;

import com.UniProject.DTO.*;
import com.UniProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/profile/{email}")
    public UserDto getUser(@PathVariable("email") String email){
        return userService.getUser(email);
    }

    @GetMapping("/show-dPlayer/{uid}")
    public List<PlayerWithoutTeamDto>showDream11Players(@PathVariable("uid") long uid){
        return userService.showPlayers(uid);
    }
    @GetMapping("/show-Point/{uid}")
    public UserPlayer showDreamPoint(@PathVariable("uid") long uid){
        return userService.showDreamPoint(uid);
    }

    @PutMapping("/dPlayer")
    public ResponseEntity<String>addDreamPlayer(@RequestBody UserPlayer player){
        if(userService.addDreamPlayer(player)){
            return ResponseEntity.status(HttpStatus.OK).body("Player added to dream team");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
