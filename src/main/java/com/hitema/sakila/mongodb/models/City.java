package com.hitema.sakila.mongodb.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class City {
    @Id
    @Column(name = "city_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="city")
    private String city;

    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "capitale")
    private boolean capitale;

    @Column(name = "country_id")
    private Long countryId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isCapitale() {
        return capitale;
    }

    public void setCapitale(boolean capitale) {
        this.capitale = capitale;
    }

    public Long getCountryId() {
        return countryId;

    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }



}

