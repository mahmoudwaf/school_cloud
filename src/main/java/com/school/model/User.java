package com.school.model;

import lombok.Data;


import java.util.Set;

@Data
public class User {
    private double userId;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;
}
