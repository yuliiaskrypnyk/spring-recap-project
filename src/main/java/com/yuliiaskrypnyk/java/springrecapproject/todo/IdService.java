package com.yuliiaskrypnyk.java.springrecapproject.todo;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {

    public String randomId() {
        return UUID.randomUUID().toString();
    }
}
