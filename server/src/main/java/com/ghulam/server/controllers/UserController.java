package com.ghulam.server.controllers;


import com.ghulam.server.models.Applicant;
import com.ghulam.server.models.Recruiter;
import com.ghulam.server.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${api.endpoints.base-url}/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/applicant")
    public ResponseEntity<?> getApplicant(Long id) {
        try {
            Applicant applicant = userService.getApplicant(id);
            return ResponseEntity.ok(applicant);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/recruiter")
    public ResponseEntity<?> getRecruiter(Long id) {
        try {
            Recruiter recruiter = userService.getRecruiter(id);
            return ResponseEntity.ok(recruiter);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        try {
            return ResponseEntity.ok(userService.getUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
