package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
