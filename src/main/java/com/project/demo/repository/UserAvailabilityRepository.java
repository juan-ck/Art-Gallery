package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.UserAvailability;

public interface UserAvailabilityRepository extends JpaRepository<UserAvailability, Integer>{

}
