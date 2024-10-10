package com.sanbro.attendence.controllers;


import com.sanbro.attendence.entities.User;
import com.sanbro.attendence.services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller class is where all the user requests are handled and required/appropriate
 * responses are sent
 */

@RestController
@RequestMapping("users/v1")
@RequiredArgsConstructor
@Validated
public class UsersController {
    private final UserService userService;

    private final EntityManager entityManager;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/users/v1/
     * Purpose: Fetches all the users in the users table
     *
     * @return List of Users
     */


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/users/v1/1 (or any other id)
     * Purpose: Fetches user with the given id
     *
     * @param id - user id
     * @return User with the given id
     */


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }


    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/users/v1/
     * Purpose: Save a User entity
     *
     * @param user - Request body is a User entity
     * @return Saved User entity
     */
    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<User> saveUser(User user) {
        entityManager.persist(user);
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/users/v1/
     * Purpose: Update a User entity
     *
     * @param user - User entity to be updated
     * @return Updated User
     */
    @PutMapping("/")
    //@PreAuthorize("hasAuthority('SCOPE_updateuser')")//TODO: scope base permissions
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/users/v1/1 (or any other id)
     * Purpose: Delete a User entity
     *
     * @param id - user's id to be deleted
     * @return a String message indicating user record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("Deleted user successfully");
    }

}
