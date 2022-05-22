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
@Table(name = "COMPANY")
public class Company implements Serializable{
    
    

    private static final long serialVersionUID = -5420102791832793566L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "CREATE_BY")
    private String createdBy;
    
    @Column(name = "CREATE_DATE")
    private Date createdDate;
    
    @Column(name = "UPDATE_BY")
    private String updateBy;
    
    @Column(name = "UPDATE_DATE")
    private Date updatedDate;
    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", address=" + address + ", createdBy=" + createdBy
                        + ", createdDate=" + createdDate + ", updateBy=" + updateBy + ", updatedDate="
                        + updatedDate + "]";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    public String getUpdateBy() {
        return updateBy;
    }
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
  
}
