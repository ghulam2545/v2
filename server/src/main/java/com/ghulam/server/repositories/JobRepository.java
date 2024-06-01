package com.ghulam.server.repositories;

import com.ghulam.server.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByTitleContainsIgnoreCase(String title);
    List<Job> findByTitleContainsIgnoreCaseAndLocation(String title, String location);
    List<Job> findByTitleContainsIgnoreCaseAndLocationAndType(String title, String location, String type);
}
