package com.hitema.sakila.mongodb.repository;

import com.hitema.sakila.mongodb.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City, Long> {
}
