package com.ghulam.server.security;

import com.ghulam.server.models.Recruiter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class RecruiterDetails implements UserDetails {

    private final Recruiter recruiter;

    public RecruiterDetails(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(recruiter.getRole().name()));
    }

    @Override
    public String getPassword() {
        return recruiter.getPassword();
    }

    @Override
    public String getUsername() {
        return recruiter.getEmail();
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
