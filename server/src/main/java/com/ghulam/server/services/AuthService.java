package com.ghulam.server.services;

import com.ghulam.server.dtos.RegisterApplicant;
import com.ghulam.server.dtos.RegisterRecruiter;
import com.ghulam.server.enums.Role;
import com.ghulam.server.models.Applicant;
import com.ghulam.server.models.Recruiter;
import com.ghulam.server.repositories.ApplicantRepository;
import com.ghulam.server.repositories.RecruiterRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final ApplicantRepository applicantRepository;
    private final RecruiterRepository recruiterRepository;
    private final PasswordEncoder encoder;

    public AuthService(
            ApplicantRepository applicantRepository,
            RecruiterRepository recruiterRepository,
            PasswordEncoder encoder
    ) {
        this.applicantRepository = applicantRepository;
        this.recruiterRepository = recruiterRepository;
        this.encoder = encoder;
    }

    public String registerApplicant(RegisterApplicant payload) {
        try {
            Applicant applicant = new Applicant();

            // applicant
            applicant.setFullname(payload.fullname());
            applicant.setUsername(payload.username());
            applicant.setEmail(payload.email());
            applicant.setPassword(encoder.encode(payload.password()));
            applicant.setContact(payload.contact());
            applicant.setSkills(payload.skills());
            applicant.setRole(Role.ROLE_APPLICANT);

            applicantRepository.save(applicant);
            return "Applicant registration success.";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Registration fails.";
    }

    public String registerRecruiter(RegisterRecruiter payload) {
        try {
            Recruiter recruiter = new Recruiter();

            // recruiter
            recruiter.setFullname(payload.fullname());
            recruiter.setUsername(payload.username());
            recruiter.setEmail(payload.email());
            recruiter.setPassword(encoder.encode(payload.password()));
            recruiter.setContact(payload.contact());
            recruiter.setCompany(payload.company());
            recruiter.setRole(Role.ROLE_RECRUITER);

            recruiterRepository.save(recruiter);
            return "Recruiter registration success.";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Registration fails.";
    }
}
