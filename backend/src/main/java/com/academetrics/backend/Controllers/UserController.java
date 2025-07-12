package com.academetrics.backend.Controllers;

import com.academetrics.backend.DTO.UserDTO.UserCreateDTO;
import com.academetrics.backend.DTO.UserDTO.UserPrimDTO;
import com.academetrics.backend.Exceptions.UsernameAlreadyExistException;
import com.academetrics.backend.Services.UserService;
import org.apache.coyote.BadRequestException;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserPrimDTO> getUserList(){
        return userService.getUserList();
    }

    @PostMapping("/")
    public UserPrimDTO createUser(@RequestBody UserCreateDTO userCreateDTO) throws UsernameAlreadyExistException {
            return userService.createUser(userCreateDTO);
    }
}
