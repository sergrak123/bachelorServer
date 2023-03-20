package com.example.tesrserver.service;

import com.example.tesrserver.entity.UserEntity;
import com.example.tesrserver.exeptions.UserAlreadyExists;
import com.example.tesrserver.exeptions.UserNotFoundExeption;
import com.example.tesrserver.model.User;
import com.example.tesrserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExists {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExists("User already exists");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundExeption {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundExeption("Not found");
        }
        return User.toModel(user);

    }

    public User deleteUser(Long id) throws UserNotFoundExeption {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundExeption("Not found");
        }
        userRepo.deleteById(id);
        return User.toModel(user);
    }
}
