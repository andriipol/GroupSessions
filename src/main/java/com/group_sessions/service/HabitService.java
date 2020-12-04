package com.group_sessions.service;

import com.group_sessions.entity.Habit;
import com.group_sessions.repository.HabitRepository;
import com.group_sessions.web.dto.HabitData;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HabitService {
    private HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public HabitData getUserById(long id) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found by id " + id));
        return new HabitData(habit);
    }
}
