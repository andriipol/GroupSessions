package com.group_sessions.web.dto;

import com.group_sessions.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserData {
    private long id;
    private String name;

    public UserData(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
