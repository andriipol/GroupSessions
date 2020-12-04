package com.group_sessions.repository;


import com.group_sessions.entity.Habit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HabitRepository extends CrudRepository<Habit, Long> {

  Optional<Habit> findById(long id);
}
