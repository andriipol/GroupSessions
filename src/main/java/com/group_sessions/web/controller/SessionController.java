package com.group_sessions.web.controller;

import com.group_sessions.service.UserService;
import com.group_sessions.web.dto.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<UserData> getUserById(@PathVariable("id") long id) {
        return ok(userService.getUserById(id));
    }
}
