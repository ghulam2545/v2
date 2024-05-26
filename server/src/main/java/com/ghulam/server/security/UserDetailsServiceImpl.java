package com.ghulam.server.security;

import com.ghulam.server.models.Applicant;
import com.ghulam.server.models.Recruiter;
import com.ghulam.server.repositories.ApplicantRepository;
import com.ghulam.server.repositories.RecruiterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicantRepository applicantRepository;
    private final RecruiterRepository recruiterRepository;

    public UserDetailsServiceImpl(ApplicantRepository applicantRepository, RecruiterRepository recruiterRepository) {
        this.applicantRepository = applicantRepository;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check if the user is an applicant
        Applicant applicant = applicantRepository.findByEmail(username).orElse(null);
        if (applicant != null) {
            return new ApplicantDetails(applicant);
        }

        // Check if the user is a recruiter
        Recruiter recruiter = recruiterRepository.findByEmail(username).orElse(null);
        if (recruiter != null) {
            return new RecruiterDetails(recruiter);
        }

        throw new UsernameNotFoundException("User not found with email: " + username);
    }
}
