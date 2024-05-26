package com.ghulam.server.dtos;

public record RegisterRecruiter(
        String fullname,
        String username,
        String email,
        String password,
        String contact,
        String company,
        String speciality
) {
}
