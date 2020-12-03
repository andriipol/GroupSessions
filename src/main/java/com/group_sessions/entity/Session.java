package com.group_sessions.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Session {
    @Id
    private long id;
    private String name;
    private String location;
}
