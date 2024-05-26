package com.ghulam.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "job")
public class Job {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String company;
    private String location;
    private String skills;
    private String experience;
    private String type;
    private String date; // todo: change to LocalDate
}
