package com.boot.example.repositories;

import com.boot.example.model.Company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long>{

    public Optional<Company> findById(Long id);
}
