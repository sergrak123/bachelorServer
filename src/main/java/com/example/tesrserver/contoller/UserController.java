package com.example.tesrserver.contoller;

import com.example.tesrserver.entity.UserEntity;
import com.example.tesrserver.exeptions.UserAlreadyExists;
import com.example.tesrserver.exeptions.UserNotFoundExeption;
import com.example.tesrserver.repository.UserRepo;
import com.example.tesrserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok().body("User saving done");
        }catch (UserAlreadyExists e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "Test data");
//            response.put("number", 1)
//            return ResponseEntity.ok(response);
            return ResponseEntity.ok().body(userService.getOne(id));
        }catch (UserNotFoundExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(userService.deleteUser(id));
        }catch (UserNotFoundExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
