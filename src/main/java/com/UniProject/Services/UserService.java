package com.UniProject.Services;

import com.UniProject.DTO.DtoImpl;
import com.UniProject.DTO.PlayerWithoutTeamDto;
import com.UniProject.DTO.UserDto;
import com.UniProject.DTO.UserPlayer;
import com.UniProject.Enteties.Player;
import com.UniProject.Enteties.User;
import com.UniProject.Repository.PlayerRepository;
import com.UniProject.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private DtoImpl dto;


    public int saveUser(UserDto userDto){
        try{
            User user= dto.UserDtoToUser(userDto);
            User newUser=userRepository.save(user);
            if(newUser!=null){
                return 1;//Success
            }
            else{
                return 2;//Failed saving
            }
        }catch (Exception e){
            return 0;//Internal server error
        }
    }

    public List<PlayerWithoutTeamDto>showPlayers(long uid){
        List<PlayerWithoutTeamDto>players=new ArrayList<>();
        List<Player>dream11=userRepository.getUserById(uid).getUDream11();
        for(Player p:dream11){
            players.add(dto.convertPlayerToPlayerWithoutTeamDto(p));
        }
        return players;
    }
    public UserPlayer showDreamPoint(long uid){
        UserPlayer user=new UserPlayer();
        user.setUid(uid);
        user.setPoint(userRepository.getDreamPoint(uid));
        return user;
    }

    @Transactional
    public void updateDreamPoints(long uid){
        List<Player>players=userRepository.getUserById(uid).getUDream11();
        int dreamPoint=0;
        for(Player p:players){
            dreamPoint+=p.getPoints();
        }
        System.out.println(dreamPoint);
        userRepository.updateDreamPoints(dreamPoint,uid);
    }

    @Transactional
    public void verifyUser(String email){
         userRepository.updateUserEnable(email);
    }
    public UserDto getUser(String email){
        return dto.UserToUserDto(userRepository.findByEmail(email));
    }

    public User checkUser(String email,String pass){
        return userRepository.findByEmailAndPassword(email,pass);
    }

    @Transactional
    public boolean addDreamPlayer(UserPlayer player){
        try{
            userRepository.addUserDream11(player.getPid(),player.getUid());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * For mail
     **/
    public boolean checkForDuplicateEmail(String email){
        User check=userRepository.findByEmail(email);
        return check==null;
    }
    public boolean checkEmailVerification(String email){
        return userRepository.findByEmail(email).isEnabled();
    }
    public int getVerCode(String toEmail){
        return emailService.sendVerEmail(toEmail);
    }
}
