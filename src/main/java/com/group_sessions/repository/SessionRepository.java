package com.group_sessions.repository;


import com.group_sessions.entity.Session;
import com.group_sessions.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends CrudRepository<Session, Long> {

  List<Session> findAll();
}
