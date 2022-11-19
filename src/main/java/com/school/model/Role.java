package com.school.model;

import lombok.Data;

@Data
public class Role {
    private Long roleId;
    private Long userId;
    private String roleName;
}
