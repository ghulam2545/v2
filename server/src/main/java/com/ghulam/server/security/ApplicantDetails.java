package com.ghulam.server.security;

import com.ghulam.server.models.Applicant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ApplicantDetails implements UserDetails {

    private final Applicant applicant;

    public ApplicantDetails(Applicant applicant) {
        this.applicant = applicant;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(applicant.getRole().name()));
    }

    @Override
    public String getPassword() {
        return applicant.getPassword();
    }

    @Override
    public String getUsername() {
        return applicant.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
