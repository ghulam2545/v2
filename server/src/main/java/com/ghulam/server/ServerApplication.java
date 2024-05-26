package com.ghulam.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghulam.server.models.Application;
import com.ghulam.server.models.Job;
import com.ghulam.server.repositories.ApplicantRepository;
import com.ghulam.server.repositories.ApplicationRepository;
import com.ghulam.server.repositories.JobRepository;
import com.ghulam.server.repositories.RecruiterRepository;
import com.ghulam.server.services.JobService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import com.ghulam.server.models.Applicant;
import com.ghulam.server.models.Recruiter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ServerApplication implements ApplicationRunner {

	private final ApplicantRepository applicantRepository;
	private final RecruiterRepository recruiterRepository;
	private final JobRepository jobRepository;
	private final ApplicationRepository applicationRepository;
	private final PasswordEncoder encoder;

    public ServerApplication(ApplicantRepository applicantRepository, RecruiterRepository recruiterRepository, JobRepository jobRepository, ApplicationRepository applicationRepository, PasswordEncoder encoder, JobService jobService) {
        this.applicantRepository = applicantRepository;
        this.recruiterRepository = recruiterRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.encoder = encoder;
    }


    public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Server is running...");
		ObjectMapper mapper = new ObjectMapper();

		ClassPathResource applicantData = new ClassPathResource("data/applicant.json");
		List<Applicant> applicants = mapper.readValue(applicantData.getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, Applicant.class));

		ClassPathResource recruiterData = new ClassPathResource("data/recruiter.json");
		List<Recruiter> recruiters = mapper.readValue(recruiterData.getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, Recruiter.class));

		ClassPathResource jobData = new ClassPathResource("data/jobs.json");
		List<Job> jobs = mapper.readValue(jobData.getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, Job.class));

		ClassPathResource applicationData = new ClassPathResource("data/application.json");
		List<Application> applications = mapper.readValue(applicationData.getInputStream(), mapper.getTypeFactory().constructCollectionType(List.class, Application.class));

		for (Applicant app : applicants) {
			app.setPassword(encoder.encode(app.getPassword()));
//			app.setApplications(List.of(applications.get(1)));
			applicantRepository.save(app);
		}
		for (Recruiter rec : recruiters) {
			rec.setPassword(encoder.encode(rec.getPassword()));
//			rec.setJobs(List.of();
//			rec.setApplications(List.of(applications.get(1)));
			recruiterRepository.save(rec);
		}

		jobRepository.saveAll(jobs);
		applicationRepository.saveAll(applications);
	}

}
