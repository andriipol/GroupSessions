package com.group_sessions.web.controller;

import com.group_sessions.entity.Habit;
import com.group_sessions.service.HabitService;
import com.group_sessions.web.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/habits", produces = APPLICATION_JSON_VALUE)
public class HabitsController {
    private HabitService habitService;

    public HabitsController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HabitData> getHabitById(@PathVariable("id") long id) {
        return ok(habitService.getHabitById(id));
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Iterable<Habit>> getAllHabits() {
        return ok(habitService.getAllHabits());
    }
}
