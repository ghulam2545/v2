package com.ghulam.server.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "application")
public class Application {
    @Id
    @GeneratedValue
    private Long id;
    private Long jobId;
    private String fullname;
    private String email;
    private String contact;
    private String education;
    private String field;
    private String performance;
    private String skills;
    private String experience;
    private String cover;
    private String portfolio;
    private String linkedin;
    private String github;
    private String other;
    private String comments;
}
