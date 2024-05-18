package com.example.springbootcrudrestapi.controller;

import com.example.springbootcrudrestapi.entity.User;
import com.example.springbootcrudrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User response = userService.createUser(user);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> createUser(@PathVariable Long id) {

        User response = userService.getUserById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> response = userService.getAllUsers();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/users/{id}/update")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {

        User response = userService.updateUser(id,user);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/users/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok().body("user deleted successfully");
    }
}
