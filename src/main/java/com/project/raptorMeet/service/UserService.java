package com.project.raptorMeet.service;

import com.project.raptorMeet.modal.User;
import com.project.raptorMeet.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


private UserRepo userRepo;
@Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void register(User user) {
        user.setStatus("online");
        userRepo.save(user);

    }

    public User login(User user) {

        User cUser=userRepo.findByEmail(user.getEmail());
        if(cUser==null){
            throw new RuntimeException("User not Found");
        }
        else{
            if(user.getPassword().equals((cUser.getPassword())))
                cUser.setStatus("online");
            else
                    throw new RuntimeException("password Incorrect");

                return cUser;
        }
//        var userIndex = IntStream.range(0, USERS_LIST.size())
//                .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        var cUser = USERS_LIST.get(userIndex);
//        if (!cUser.getPassword().equals(user.getPassword())) {
//            throw new RuntimeException("Password incorrect");
//        }
//        cUser.setStatus("online");
//        return cUser;
    }

    public void logout(String email) {
        User cUser=userRepo.findByEmail(email);
        cUser.setStatus("offline");
//        var userIndex = IntStream.range(0, USERS_LIST.size())
//                .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public List<User> findAll() {
    List<User> allUser=userRepo.findAll();
    return allUser;
    }
}
