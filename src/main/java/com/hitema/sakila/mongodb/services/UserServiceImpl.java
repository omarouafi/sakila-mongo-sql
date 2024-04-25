package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        if ( user.getLastUpdate() == null)
            user.setLastUpdate(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public User read(String email) {
        return repository.findById(email).orElse(null);
    }

    @Override
    public User update(User user) {
        user.setLastUpdate(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public boolean delete(String email) {
        repository.deleteById(email);
        return ( read(email) == null );
    }

    @Override
    public List<User> readAll() {
        return repository.findAll();
    }

    @Override
    public List<User> searchBy(String expr) {
        return repository.findByFirstNameContainingOrLastNameContaining(expr, expr);
    }

    @Override
    public byte[] getPicture(String email) {
        var user = read(email) ;
        return ( user != null ? user.getPicture() : null ) ;
    }

    @Override
    public void savePicture(String email, byte[] picture) {
        User user = read(email);
        if ( user !=null ){
            user.setPicture(picture);
            repository.save(user);
        }else
            log.warn("Mise à jour de photo sur profil inexistant :{}", email);
    }
}
