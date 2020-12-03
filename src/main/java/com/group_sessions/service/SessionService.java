package com.group_sessions.service;

import com.group_sessions.entity.Session;
import com.group_sessions.entity.User;
import com.group_sessions.repository.SessionRepository;
import com.group_sessions.repository.UserRepository;
import com.group_sessions.web.dto.UserData;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getUserById() {
        return sessionRepository.findAll();
    }
}
