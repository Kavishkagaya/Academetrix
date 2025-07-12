package com.academetrics.backend.Repositories;

import com.academetrics.backend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User getUserByUsername(String username);
}
