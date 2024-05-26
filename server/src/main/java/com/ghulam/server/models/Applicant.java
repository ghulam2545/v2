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
@Entity(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue
    private Long id;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String contact;
    private String skills;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Application> applications = new ArrayList<>();
    private Role role;
}
