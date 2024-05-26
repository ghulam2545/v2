package com.ghulam.server.dtos;

public record JobRequest(
        String title,
        String company,
        String location,
        String skills,
        String experience,
        String type
) {
}
