package com.ghulam.server.services;

import com.ghulam.server.dtos.JobRequest;
import com.ghulam.server.models.Job;
import com.ghulam.server.models.Recruiter;
import com.ghulam.server.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserService userService;

    public JobService(JobRepository jobRepository, UserService userService) {
        this.jobRepository = jobRepository;
        this.userService = userService;
    }

    public Job save(Long id, JobRequest request) {
        Job job = new Job();
        job.setTitle(request.title());
        job.setCompany(request.company());
        job.setLocation(request.location());
        job.setSkills(request.skills());
        job.setExperience(request.experience());
        job.setType(request.type());
        job.setDate("Today");

        Recruiter recruiter = userService.getRecruiter(id);
        recruiter.getJobs().add(job);

        return jobRepository.save(job);
    }

    public Job get(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    public List<Job> search(String keyword, String location, String type) {
        if (location == null && type == null) {
            return jobRepository.findByTitleContainsIgnoreCase(keyword);
        } else if (type == null) {
            return jobRepository.findByTitleContainsIgnoreCaseAndLocation(keyword, location);
        } else {
            return jobRepository.findByTitleContainsIgnoreCaseAndLocationAndType(keyword, location, type);
        }
    }
}
