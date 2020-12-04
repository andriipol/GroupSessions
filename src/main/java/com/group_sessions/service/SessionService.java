package com.group_sessions.service;

import com.group_sessions.entity.Session;
import com.group_sessions.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSessionByID(Long sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow();
    }

    public List<Session> getSessionByHabit(Long habitId) {
        return sessionRepository.findAllByHabit_Id(habitId);
    }
}
