package com.example.tesrserver.repository;

import com.example.tesrserver.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);


//    UserEntity(String username);
}
