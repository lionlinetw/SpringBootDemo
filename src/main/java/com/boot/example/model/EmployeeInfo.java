package com.boot.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInfo implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 3493444963246106248L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "USER_ID")
    private String userId;
    
    @Column(name = "ROLE")
    private String role;
    
    @Override
    public String toString() {
        return "EmployeeInfo [id=" + id + ", userId=" + userId + ", role=" + role + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
  
}
