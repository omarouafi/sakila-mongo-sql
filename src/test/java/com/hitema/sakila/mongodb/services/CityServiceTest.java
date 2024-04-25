package com.hitema.sakila.mongodb.services;

import com.hitema.sakila.mongodb.models.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CityServiceTest.class);

    @Autowired
    CityService service;

    @Test
    void create() {
        City city = new City();
        city.setCity("Paris");
        city.setCountryId(1L);
        city.setLastUpdate( java.time.LocalDateTime.now());
        City createdCity = service.create(city);
        log.trace("{}", createdCity);
        assertNotNull(createdCity);
        // remove the created city
        Boolean deleted = service.delete(createdCity.getId());
        assertTrue(deleted);
    }
    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
    }
}