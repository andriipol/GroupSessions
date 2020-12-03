package com.group_sessions.web.controller;

import com.group_sessions.entity.Session;
import com.group_sessions.service.SessionService;
import com.group_sessions.service.UserService;
import com.group_sessions.web.dto.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api/sessions", produces = APPLICATION_JSON_VALUE)
public class SessionController {
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<List<Session>> getUserById() {
        return ok(sessionService.getUserById());
    }

    @GetMapping(value = "/id/{sessionId}")
    public String getSession(@PathVariable Long sessionId) {
        return "Session ID " +sessionId + "You should be authorized";
    }

    @GetMapping(value = "/create")
    public String createSession() {
        return "You have needed permission for creation";
    }
}
