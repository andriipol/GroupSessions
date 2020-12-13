package com.group_sessions.web.controller;

import com.group_sessions.entity.Habit;
import com.group_sessions.entity.HabitDTO;
import com.group_sessions.service.HabitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api/habits", produces = APPLICATION_JSON_VALUE)
public class HabitsController {
    private HabitService habitService;

    public HabitsController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Habit> getHabitById(@PathVariable("id") long id) {
        return ok(habitService.getHabitById(id));
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Iterable<Habit>> getAllHabits() {
        return ok(habitService.getAllHabits());
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createHabit(@RequestBody HabitDTO habitDTO) throws URISyntaxException {
        Habit habit = habitService.createHabit(habitDTO);
        return created(new URI("/id/" + habit.getId())).build();
    }

    @DeleteMapping(value = "/delete/{habitId}")
    public void removeSession(@PathVariable Long habitId) {
        habitService.deleteHabit(habitId);
    }
}
