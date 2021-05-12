package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

}
