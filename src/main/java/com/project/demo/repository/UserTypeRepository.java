package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer>{

}
