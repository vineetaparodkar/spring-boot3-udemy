package com.example.springbootcrudrestapi.controller;

import com.example.springbootcrudrestapi.dto.UserDto;
import com.example.springbootcrudrestapi.exception.ErrorDetails;
import com.example.springbootcrudrestapi.exception.ResourceNotFoundException;
import com.example.springbootcrudrestapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Tag(
        name = "CRUD APIs for User Resource",
        description = "CRUD APIs for User Resource"
)
public class UserController {
    private final UserService userService;

    @Operation(
            summary="create user",
            description="create user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "resource created"
    )
    @PostMapping("/user/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {

        UserDto response = userService.createUser(user);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) throws ResourceNotFoundException {

        UserDto response = userService.getUserById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> response = userService.getAllUsers();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/users/{id}/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto user) throws ResourceNotFoundException {

        UserDto response = userService.updateUser(id, user);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/users/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok().body("user deleted successfully");
    }

    //sample for handling the specific exception at controller level using annotation exception handler and not at global exception using advisor
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleUserNotFoundException(ResourceNotFoundException exception,
//                                                                    WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
