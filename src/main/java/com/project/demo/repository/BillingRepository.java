package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer>{

}
