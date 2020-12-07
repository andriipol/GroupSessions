package com.group_sessions.web.dto;

import com.group_sessions.entity.Session;
import lombok.Data;

@Data
public class SessionDTO {
    private long id;
    private String title;
    private String location;
    private String habit_title;


    public SessionDTO(Session session) {
        this.id = session.getId();
        this.title = session.getTitle();
        this.location = session.getLocation();
        this.habit_title = session.getHabit() != null ? session.getHabit().getTitle() : null;
    }
}
