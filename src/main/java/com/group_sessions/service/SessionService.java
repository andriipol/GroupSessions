package com.group_sessions.service;

import com.group_sessions.entity.Session;
import com.group_sessions.repository.SessionRepository;
import com.group_sessions.web.dto.SessionDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<SessionDTO> getAllSessions() {
        return sessionRepository.findAll().stream().map(SessionDTO::new).collect(Collectors.toList());
    }

    public Session getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow();
    }

    public List<Session> getSessionByHabit(Long habitId) {
        return sessionRepository.findAllByHabit_Id(habitId);
    }

    public Session createSession(final Session sessionData) {
        Session session = new Session();
        session.setTitle(sessionData.getTitle());
        session.setSummary(sessionData.getSummary());
        session.setHabit(sessionData.getHabit());
        session.setLocation(sessionData.getLocation());
        return sessionRepository.save(session);
    }

    public void deleteSession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new EntityNotFoundException("Session not found by id " + sessionId));
        sessionRepository.delete(session);
    }
}
