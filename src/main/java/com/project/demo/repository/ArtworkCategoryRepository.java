package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.ArtworkCategory;

public interface ArtworkCategoryRepository extends JpaRepository<ArtworkCategory, Integer>{

}
