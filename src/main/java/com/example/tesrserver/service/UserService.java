package com.example.tesrserver.service;

import com.example.tesrserver.entity.UserEntity;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.exeptions.UserAlreadyExists;
import com.example.tesrserver.exeptions.UserNotFoundException;
import com.example.tesrserver.model.user.User;
import com.example.tesrserver.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExists {
        if (userRepo.findByEmail(user.getEmail()) != null){
            throw new UserAlreadyExists("User already exists");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundException("Not found");
        }
        return user;

    }

    public User authorization(String email, String password) throws NotFoundException, UserNotFoundException {
        UserEntity userCandidate = userRepo.findByEmail(email);
        if (userCandidate == null){
            throw new UserNotFoundException("User not found");
        }
        if (!userCandidate.getPassword().equals(password)){
            throw new NotFoundException("User password dont matches");
        }
        return User.toModel(userCandidate);
    }
}
