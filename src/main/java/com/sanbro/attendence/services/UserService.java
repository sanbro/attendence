package com.sanbro.attendence.services;


import com.sanbro.attendence.entities.User;
import com.sanbro.attendence.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service layer is where all the business logic lies
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    final private UserRepo userRepo;


    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            return new ArrayList<>();
        } else return users;

    }


    public User getUserById(Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    public User getUserByName(String name){
        Optional<User> optionalUser = userRepo.findByName(name);
        return optionalUser.orElse(null);
    }

    public User saveUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepo.save(user);
    }


    public User updateUser(User user) {
        Optional<User> existingUser = userRepo.findById(user.getId());
        user.setUpdatedAt(LocalDateTime.now());

        if (existingUser.isPresent()) {
            user.setCreatedAt(existingUser.get().getCreatedAt());
            user.setId(existingUser.get().getId());
        }

        return userRepo.save(user);

    }


    public void deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
    }
}
