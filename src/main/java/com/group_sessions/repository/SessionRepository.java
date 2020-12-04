package com.group_sessions.repository;


import com.group_sessions.entity.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {

    List<Session> findAll();

    List<Session> findAllByHabit_Id(Long habitId);
}
