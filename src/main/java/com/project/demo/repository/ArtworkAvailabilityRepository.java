package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.ArtworkAvailability;

public interface ArtworkAvailabilityRepository extends JpaRepository<ArtworkAvailability, Integer>{

}
