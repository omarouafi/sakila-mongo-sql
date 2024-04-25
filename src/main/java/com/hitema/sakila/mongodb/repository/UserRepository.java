package com.hitema.sakila.mongodb.repository;

import com.hitema.sakila.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
