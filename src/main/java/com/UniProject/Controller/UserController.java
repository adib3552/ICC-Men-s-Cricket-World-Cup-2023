package com.UniProject.Controller;

import com.UniProject.DTO.LoginDetails;
import com.UniProject.DTO.PlayerWithoutTeamDto;
import com.UniProject.DTO.UserPlayer;
import com.UniProject.Enteties.User;
import com.UniProject.DTO.VerCode;
import com.UniProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private int code;
    private String userEmail;

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String>userLogin(@RequestBody LoginDetails info){
        User tempUser=userService.checkUser(info.getEmail(),info.getPassword());
        System.out.println(tempUser);
        if(tempUser!=null){
            if(userService.checkEmailVerification(info.getEmail())){
                return ResponseEntity.status(HttpStatus.OK).body("Provided info is valid is valid");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email is not verified");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("wrong email or password");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        if (!userService.checkForDuplicateEmail(user.getEmail())) {
            // Redirect back to the form with an error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exist try another email");
        }
        user.setEnabled(false);
        int code = userService.saveUser(user);
        if(code==1){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Information saved Successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving");
    }

    @PostMapping("/check")
    public ResponseEntity<String> show(@RequestBody VerCode verCode){
        int userCode = verCode.getCode();
        if(userCode==code){
            userService.verifyUser(userEmail);
            return ResponseEntity.status(HttpStatus.OK).body("Verified");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Wrong verification code");
    }

    @GetMapping("/verify/{email}")
    public ResponseEntity<String> sendEmail(@PathVariable String email){
        userEmail=email;
        code=userService.getVerCode(email);
        System.out.println(code);
        return ResponseEntity.status(HttpStatus.OK).body("Sent");
    }

    @GetMapping("/profile/{email}")
    public User getUser(@PathVariable("email") String email){
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
