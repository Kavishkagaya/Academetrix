package com.academetrics.backend.DTO.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {
    private String username;
    private String role;
    private Map<String, Object> permisions;
}
