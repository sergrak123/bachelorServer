package com.example.tesrserver.contoller;

import com.example.tesrserver.entity.UserEntity;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.exeptions.UserAlreadyExists;
import com.example.tesrserver.exeptions.UserNotFoundException;
import com.example.tesrserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok().body("User saving done");
        } catch (UserAlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/auth")
    public ResponseEntity authorization(@RequestParam String email,
                                        @RequestParam String password) {
        try {
            return ResponseEntity.ok().body(userService.authorization(email, password));
        } catch (UserNotFoundException | NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    //@DeleteMapping("/{id}")
    //public ResponseEntity deleteUser(@PathVariable Long id){
}
