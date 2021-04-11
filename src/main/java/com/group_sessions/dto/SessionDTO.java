package com.group_sessions.dto;

import com.group_sessions.entity.Session;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
public class SessionDTO {
    private long id;
    private String title;
    private String summary;
    private String location;
    private long habit_id;
    private String habit_title;
    private int capacity;
    private String organizer;
    private String host_email;
    private String join_url;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;
    private Integer duration;



    public SessionDTO(Session session) {
        this.id = session.getId();
        this.title = session.getTitle();
        this.summary = session.getSummary();
        this.location = session.getLocation();
        this.location = session.getLocation();
        this.capacity = session.getCapacity();
        this.organizer = session.getOrganizer();
        this.start_date = session.getStart_date();
        this.end_date = session.getEnd_date();
        this.host_email = session.getHost_email();
        this.duration = session.getDuration();
        this.join_url = session.getJoin_url();

        if (session.getHabit() != null) {
            this.habit_id = session.getHabit().getId();
            this.habit_title = session.getHabit().getTitle();
        }
    }
}
