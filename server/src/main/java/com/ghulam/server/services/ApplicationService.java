package com.ghulam.server.services;

import com.ghulam.server.dtos.ApplicationRequest;
import com.ghulam.server.models.Application;
import com.ghulam.server.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final UserService userService;
    private final ApplicationRepository applicationRepository;

    public ApplicationService(UserService userService, ApplicationRepository applicationRepository) {
        this.userService = userService;
        this.applicationRepository = applicationRepository;
    }

    public Application save(Long userId, Long jobId, ApplicationRequest request) {
        Application application = new Application();

        application.setJobId(jobId);
        application.setFullname(request.fullname());
        application.setEmail(request.email());
        application.setContact(request.contact());
        application.setEducation(request.education());
        application.setField(request.field());
        application.setPerformance(request.performance());
        application.setSkills(request.skills());
        application.setExperience(request.experience());
        application.setCover(request.cover());
        application.setPortfolio(request.portfolio());
        application.setLinkedin(request.linkedin());
        application.setGithub(request.github());
        application.setOther(request.other());
        application.setComments(request.comments());

        userService.getApplicant(userId).getApplications().add(application);

        return applicationRepository.save(application);
    }

    public Application get(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public List<Application> getAll() {
        return applicationRepository.findAll();
    }
}
