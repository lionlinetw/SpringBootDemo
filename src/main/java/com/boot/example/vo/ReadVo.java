package com.boot.example.vo;

import com.boot.example.model.Client;
import com.boot.example.model.Company;

import java.util.List;

public class ReadVo extends ResultVo {

    private List<Company> companyList;
    private List<Client> ClientList;

    @Override
    public String toString() {
        return "ReadVo [companyList=" + companyList + ", ClientList=" + ClientList + "]";
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Client> getClientList() {
        return ClientList;
    }

    public void setClientList(List<Client> clientList) {
        ClientList = clientList;
    }

}
