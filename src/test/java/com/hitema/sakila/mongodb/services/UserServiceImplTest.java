package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.User;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    UserService service;

    @Test
        @DisplayName("Should Delete User")
    void shouldDeleteUser() {
        log.info("<<<<<<<<<START shouldDeleteUser >>>>>>>>>");
        

        log.info("<<<<<<<<<END   shouldDeleteUser >>>>>>>>>");
    }
    @Test
        @DisplayName("Should Create Me and Other")
    void shouldCreateMeAndOther() {
        log.info("<<<<<<<<<START shouldCreateMeAndOther >>>>>>>>>");
        if ( service.read("me@gmail.com") == null ) {
            User me = new User("me@gmail.com", "Rick", "tarhack");
            service.create(me);
            log.info("User 1 :{} created",me);
            assertTrue(service.read(me.getEmail()) != null , "ERROR User 1 creation DOS NOT WORK !!!");
        }
        if ( service.read("other@gmail.com") == null ) {
            User other = new User("other@gmail.com", "Other", "DEVELOPPEUR");
            service.create(other);
            log.info("User 2 :{} created",other);
            assertTrue(service.read(other.getEmail()) != null , "ERROR User 2 creation DOS NOT WORK !!!");
        }
        if ( service.read("other2@gmail.com") == null ) {
            User other = new User("other2@gmail.com", "Other 2", "DEVELOPPEUR DEUX");
            service.create(other);
            log.info("User Other 2 :{} created",other);
            assertTrue(service.read(other.getEmail()) != null , "ERROR User 2 creation DOS NOT WORK !!!");
        }
        log.info("<<<<<<<<<END   shouldCreateMeAndOther >>>>>>>>>");
    }
    @Test
    void create() {
    }

    @Test
    void read() {
        User me = service.read("me@gmail.com");
        assertNotNull(me);
        log.info("User 1 :{} read",me);

    }

    @Test
    @Disabled
    void update() {
    }

    @Test
    void delete() {
    }
}