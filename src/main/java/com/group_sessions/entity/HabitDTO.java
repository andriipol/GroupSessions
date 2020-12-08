package com.group_sessions.entity;

import com.group_sessions.entity.Habit;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HabitDTO {
    private long id;
    private String title;

    public HabitDTO(Habit habit){
        this.id = habit.getId();
        this.title = habit.getTitle();
    }
}
