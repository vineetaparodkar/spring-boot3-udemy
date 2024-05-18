package com.example.springbootcrudrestapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "user dto model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @Schema(description = "user first name")
    //should be not null or empty
    @NotEmpty(message = "firstname cannot be empty or null")
    private String firstName;

    @Schema(description = "user last name")
    @NotEmpty(message = "firstname cannot be empty or null")
    private String lastName;

    @Schema(description = "user email address")
    //should be not null or empty and email should be valid
    @NotEmpty(message = "firstname cannot be empty or null")
    @Email(message = "user email should be valid")
    private String email;
}
