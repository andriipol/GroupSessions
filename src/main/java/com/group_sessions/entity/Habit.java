package com.group_sessions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
public class Habit {
    @Id
    private long id;
    private String title;
    private String summary;
}
