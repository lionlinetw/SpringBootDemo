package com.boot.example.vo;

public class DoCrudVo {
    
    private String userId;
    private Long companyId;
    private String companyName;
    private String companyAddress;
    private Long clientId;
    private String clientEmail;
    private String clientName;
    private String clientPhone;

    @Override
    public String toString() {
        return "CreateVo [userId=" + userId + ", companyId=" + companyId + ", companyName=" + companyName
                        + ", companyAddress=" + companyAddress + ", clientId=" + clientId + ", clientEmail="
                        + clientEmail + ", clientName=" + clientName + ", clientPhone=" + clientPhone + "]";
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

   
}
