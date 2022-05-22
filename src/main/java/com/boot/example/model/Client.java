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
@Table(name = "CLIENT")
public class Client implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -1944472786193061831L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "COMPANY_ID")
    private Long companyId;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE")
    private String phone;
    
    @Column(name = "CREATE_BY")
    private String createdBy;
    
    @Column(name = "CREATE_DATE")
    private Date createdDate;
    
    @Column(name = "UPDATE_BY")
    private String updatedBy;
    
    @Column(name = "UPDATE_DATE")
    private Date updatedDate;

    @Override
    public String toString() {
        return "Client [id=" + id + ", companyId=" + companyId + ", name=" + name + ", email=" + email + ", phone="
                        + phone + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
                        + updatedBy + ", updatedDate=" + updatedDate + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


}
