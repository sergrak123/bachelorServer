//package com.example.tesrserver.contoller;
//
//import com.example.tesrserver.entity.TodoEntity;
//import com.example.tesrserver.service.TodoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/todos")
//public class TodoController {
//
//    @Autowired
//    private TodoService todoService;
//
//    @PostMapping
//    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
//                                     @RequestParam Long userId) {
//        try {
//            return ResponseEntity.ok().body(todoService.createTodo(todo,userId));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error");
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity completeTodo(@RequestParam Long id) {
//        try {
//            return ResponseEntity.ok().body(todoService.completeTodo(id));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error");
//        }
//    }
//
//}
