package com.sanbro.attendence.repos;

import com.sanbro.attendence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository is an interface that provides access to data in a database
 * ---
 * In the declaration “JpaRepository<User, Integer>” the term “User”
 * represents the entity, while “Integer”
 * signifies the data type of the identifier for this entity.
 */

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);
}
