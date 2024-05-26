package com.ghulam.server.dtos;

public record ApplicationRequest(
        String fullname,
        String email,
        String contact,
        String education,
        String field,
        String performance,
        String skills,
        String experience,
        String cover,
        String portfolio,
        String linkedin,
        String github,
        String other,
        String comments
) {
}
