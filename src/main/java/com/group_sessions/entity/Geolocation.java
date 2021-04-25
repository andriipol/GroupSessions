package com.group_sessions.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Geolocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double longitude;
    private double latitude;
    private String address;
}
