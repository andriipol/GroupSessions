package com.group_sessions.service;

import com.group_sessions.entity.User;
import com.group_sessions.exception.BadRequestException;
import com.group_sessions.exception.FileNotFoundException;
import com.group_sessions.repository.UserRepository;
import com.group_sessions.web.dto.UserData;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserData getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by id " + id));
        return new UserData(user);
    }
}
