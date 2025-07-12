package com.academetrics.backend.DTO.UserDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPrimDTO {
    private Integer user_id;
    private String username;
    private String role;
    private String fname;
    private String lname;
    private String email;
    private String telephone;
}
