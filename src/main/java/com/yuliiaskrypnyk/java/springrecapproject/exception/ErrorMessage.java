package com.yuliiaskrypnyk.java.springrecapproject.exception;

import java.time.LocalDateTime;

public record ErrorMessage(String message, LocalDateTime timestamp) {
}
