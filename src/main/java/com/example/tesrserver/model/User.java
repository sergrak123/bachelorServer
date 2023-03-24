//package com.example.tesrserver.model;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
////только те поля, которые нужные для client
//public class User {
//    private Long id;
//    private String username;
//    private List<Todo> todos;
//
//    public static User toModel(UserEntity userEntity){
//        User model = new User();
//        model.setId(userEntity.getId());
//        model.setUsername(userEntity.getUsername());
//        //можно просто циклом List<TDEntity>-> List<Entity>
////        model.setTodos(userEntity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
//        model.setTodos(userEntity.getTodos().stream().map(todo -> Todo.toModel(todo)).collect(Collectors.toList()));
//        return model;
//    }
//
//    public User() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public List<Todo> getTodos() {
//        return todos;
//    }
//
//    public void setTodos(List<Todo> todos) {
//        this.todos = todos;
//    }
//}
