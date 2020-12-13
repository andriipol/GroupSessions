package com.group_sessions.service;

import com.group_sessions.entity.Habit;
import com.group_sessions.entity.HabitDTO;
import com.group_sessions.repository.HabitRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class HabitService {
    private HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Habit getHabitById(long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found by id " + id));

    }

    public Iterable<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Habit createHabit(final HabitDTO habitDTO) {
        Habit habit = new Habit();
        habit.setTitle(habitDTO.getTitle());
        habit.setSummary(habitDTO.getSummary());

        return habitRepository.save(habit);
    }

    public void deleteHabit(Long habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found by id " + habitId));
        habitRepository.delete(habit);
    }
}
