package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, Integer>{

}
