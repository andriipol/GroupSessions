package com.group_sessions.web.dto;

import com.group_sessions.entity.Habit;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HabitData {
    private long id;
    private String title;

    public HabitData(Habit habit){
        this.id = habit.getId();
        this.title = habit.getTitle();
    }
}
