package com.academetrics.backend.Services;

import com.academetrics.backend.DTO.UserDTO.UserCreateDTO;
import com.academetrics.backend.DTO.UserDTO.UserPrimDTO;
import com.academetrics.backend.Exceptions.UsernameAlreadyExistException;
import com.academetrics.backend.Models.User;
import com.academetrics.backend.Repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, ObjectMapper objectMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public User convertCreateDTOtoUser(UserCreateDTO userCreateDTO){
        User user = new User();
        user.setUsername(userCreateDTO.getUsername());
        user.setRole(userCreateDTO.getRole());
        try {
            user.setPermisions(objectMapper.writeValueAsString(userCreateDTO.getPermisions()));
        }catch (JsonProcessingException e){
            throw new RuntimeException("Failed to convert permissions to JSON", e);
        }
        return user;
    }

    public List<UserPrimDTO> getUserList(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserPrimDTO.class))
                .collect(Collectors.toList());
    }

    public Boolean isUsernameAvailable(String username){
        User user = userRepository.getUserByUsername(username);
        if(user == null) return false;
        return true;
    }

    public UserPrimDTO createUser(UserCreateDTO userCreateDTO) throws BadRequestException {
        if(isUsernameAvailable(userCreateDTO.getUsername())) throw new UsernameAlreadyExistException(userCreateDTO.getUsername());
        User user = convertCreateDTOtoUser(userCreateDTO);
        user = userRepository.save(user);
        return modelMapper.map(user, UserPrimDTO.class);
    }
}
