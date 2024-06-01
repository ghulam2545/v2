package com.ghulam.server.controllers;

import com.ghulam.server.dtos.JobRequest;
import com.ghulam.server.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${api.endpoints.base-url}/jobs")
@CrossOrigin("*")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/new-job")
    public ResponseEntity<?> save(
            @RequestParam Long id,
            @RequestBody JobRequest jobRequest
    ) {
           try {
            return ResponseEntity.ok(jobService.save(id, jobRequest));
           } catch (Exception e) {
               return ResponseEntity.badRequest().body(e.getMessage());
           }
    }

    @GetMapping("/get-job")
    public ResponseEntity<?> get(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(jobService.get(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs() {
        try {
            return ResponseEntity.ok(jobService.getJobs());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // todo: fix this endpoint
    @PostMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam(required = true) String keyword,
            @RequestParam(required = false, defaultValue = "") String location,
            @RequestParam(required = false, defaultValue = "") String type
    ) {
        try {
            return ResponseEntity.ok(jobService.search(keyword, location, type));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
