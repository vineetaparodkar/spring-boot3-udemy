package com.example.springbootcrudrestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id // used for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //uses strategy for generation of identity
    private Long id;
    @Column(name="first_name",nullable = false) //for camel case by default jakarta does first_name
    private String firstName;
    private String lastName;
    private String email;
}
