package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User read(String email);
    User update(User user);
    boolean delete(String email);
    List<User> readAll();
    List<User> searchBy(String expr);

    byte[] getPicture(String email);

     void savePicture(String email, byte[] picture);

}
