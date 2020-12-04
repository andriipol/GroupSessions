package com.group_sessions.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Session {
    @Id
    private long id;
    private String title;
    private String summary;
    private String location;
    private Date start_date;
    private Date end_date;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "habit_id")
    private Habit habit;
}
