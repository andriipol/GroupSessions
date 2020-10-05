package com.group_sessions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

@SpringBootApplication
public class GroupSessionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupSessionsApplication.class, args);
    }

}
