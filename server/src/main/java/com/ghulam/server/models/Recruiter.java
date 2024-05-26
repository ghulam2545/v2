package com.ghulam.server.models;

import com.ghulam.server.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "recruiter")
public class Recruiter {
    @Id
    @GeneratedValue
    private Long id;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String contact;
    private String company;
    private String speciality;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Job> jobs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();

    private Role role;

}
