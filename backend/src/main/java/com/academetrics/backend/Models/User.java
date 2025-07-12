package com.academetrics.backend.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(nullable = false)
    private String username;
    private String password;
    @Column(nullable = false)
    private String role;
    private String fname;
    private String lname;
    private String email;
    private String telephone;
    private String state;
    @Column(columnDefinition = "json")
    private String permisions;
}
