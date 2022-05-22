package com.boot.example.repositories;

import com.boot.example.model.EmployeeInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {
    
    public EmployeeInfo findByUserId(String userId);

}
