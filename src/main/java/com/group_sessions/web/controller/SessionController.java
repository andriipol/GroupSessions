package com.group_sessions.web.controller;

import com.group_sessions.entity.Session;
import com.group_sessions.entity.SessionDTO;
import com.group_sessions.service.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.created;
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
    public ResponseEntity<List<SessionDTO>> getAllSessions() {
        return ok(sessionService.getAllSessions());
    }

    @GetMapping(value = "/id/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long sessionId) {
        return ok(sessionService.getSessionById(sessionId));
    }

    @GetMapping(value = "/habit/{habitId}")
    public ResponseEntity<List<Session>> getSessionsByHabit(@PathVariable Long habitId) {
        return ok(sessionService.getSessionByHabit(habitId));
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createSession(@RequestBody SessionDTO sessionDTO) throws URISyntaxException {
        Session session = sessionService.createSession(sessionDTO);
        return created(new URI("/id/" + session.getId())).build();
    }

    @DeleteMapping(value = "/delete/{sessionId}")
    public void removeSession(@PathVariable Long sessionId) {
        sessionService.deleteSession(sessionId);
    }
}
