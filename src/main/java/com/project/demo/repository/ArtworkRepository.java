package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Artwork;

public interface ArtworkRepository extends JpaRepository<Artwork, Integer>{

}
