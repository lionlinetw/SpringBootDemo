package com.boot.example.service;

import com.boot.example.Enums.ActionResultStatus;
import com.boot.example.Enums.CRUD;
import com.boot.example.model.Client;
import com.boot.example.model.Company;
import com.boot.example.model.EmployeeInfo;
import com.boot.example.repositories.ClientRepository;
import com.boot.example.repositories.CompanyRepository;
import com.boot.example.repositories.EmployeeInfoRepository;
import com.boot.example.vo.DoCrudVo;
import com.boot.example.vo.ReadVo;
import com.boot.example.vo.ResultVo;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class BootService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    private static final String USERID_IS_EMPTY = "User id is is empty";
    private static final String USER_NOT_ON_THE_JOB = "User is not on the job";

    private static final String USER_NOT_ALLOW_CREATE_DATA = "User is not allow create function";
    private static final String USER_NOT_ALLOW_UPDATE_DATA = "User is not allow update function";
    private static final String USER_NOT_ALLOW_READ_DATA = "User is not allow read function";
    private static final String USER_NOT_ALLOW_DELETE_DATA = "User is not allow delete function";

    private static final String VIOLATE_CREATE_RULE =
                    "Company Address,name and Client Email,Phone,Name can not all empty";
    private static final String VIOLATE_UPDATE_RULE = "Company ID and Client ID can not all empty";
    
    private static final String COMPANY_ID_NOT_EXIST_IN_DB = "Company ID is not exist in db";
    private static final String CLIENT_ID_NOT_EXIST_IN_DB = "Client ID is not exist in db";

    public boolean isUserAllowCreateAction(String userRole) {
        boolean result = false;

        if ("SuperUser".equals(userRole) || "Operator".equals(userRole)) {
            result = true;
        }

        return result;
    }

    public boolean isUserAllowReadAction(String userRole) {
        boolean result = false;

        if ("SuperUser".equals(userRole) || "Operator".equals(userRole) || "Manager".equals(userRole)) {
            result = true;
        }

        return result;
    }

    public boolean isUserAllowUpdateAction(String userRole) {
        boolean result = false;

        if ("SuperUser".equals(userRole) || "Manager".equals(userRole)) {
            result = true;
        }

        return result;
    }

    public boolean isUserAllowDeleteAction(String userRole) {
        boolean result = false;

        if ("SuperUser".equals(userRole) || "Manager".equals(userRole)) {
            result = true;
        }

        return result;
    }

    public void checkCrudBasicInputValid(ResultVo resultVo, DoCrudVo inputVo, CRUD inputCrud) {
        checkUserIdEmpty(resultVo, inputVo.getUserId());
        checkUserAuthValid(resultVo, inputVo.getUserId(), inputCrud);
    }

    public void checkUserIdEmpty(ResultVo resultVo, String userId) {
        if (Strings.isEmpty(userId)) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(USERID_IS_EMPTY);
        }
    }

    public void checkUserAuthValid(ResultVo resultVo, String userId, CRUD inputCrud) {
        if (!Strings.isEmpty(userId)) {
            EmployeeInfo employeeInfo = employeeInfoRepository.findByUserId(userId);

            if (employeeInfo == null) {
                resultVo.setStatus(ActionResultStatus.FAIL);
                resultVo.setErrorMsg(USER_NOT_ON_THE_JOB);
            } else {

                if (CRUD.CREATE == inputCrud && !isUserAllowCreateAction(employeeInfo.getRole())) {
                    resultVo.setStatus(ActionResultStatus.FAIL);
                    resultVo.setErrorMsg(USER_NOT_ALLOW_CREATE_DATA);
                }

                if (CRUD.READ == inputCrud && !isUserAllowReadAction(employeeInfo.getRole())) {
                    resultVo.setStatus(ActionResultStatus.FAIL);
                    resultVo.setErrorMsg(USER_NOT_ALLOW_READ_DATA);
                }

                if (CRUD.UPDATE == inputCrud && !isUserAllowUpdateAction(employeeInfo.getRole())) {
                    resultVo.setStatus(ActionResultStatus.FAIL);
                    resultVo.setErrorMsg(USER_NOT_ALLOW_UPDATE_DATA);
                }

                if (CRUD.DELETE == inputCrud && !isUserAllowDeleteAction(employeeInfo.getRole())) {
                    resultVo.setStatus(ActionResultStatus.FAIL);
                    resultVo.setErrorMsg(USER_NOT_ALLOW_DELETE_DATA);
                }
            }
        }
    }

    public ResultVo create(DoCrudVo inputVo) {
        ResultVo resultVo = new ResultVo();

        try {
            checkCrudBasicInputValid(resultVo, inputVo, CRUD.CREATE);
            checkCreateInputLimit(resultVo, inputVo);

            if (resultVo.getStatus() == ActionResultStatus.SUCCESS) {
                doCreateAction(inputVo);
            }

        } catch (Exception e) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(e.toString());
        }

        return resultVo;
    }

    public void checkCreateInputLimit(ResultVo resultVo, DoCrudVo inputVo) {
        if (Strings.isEmpty(inputVo.getCompanyName()) && Strings.isEmpty(inputVo.getCompanyAddress())
                        && Strings.isEmpty(inputVo.getClientPhone())
                        && Strings.isEmpty(inputVo.getClientEmail())
                        && Strings.isEmpty(inputVo.getClientName())) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(VIOLATE_CREATE_RULE);
        }
    }

    public void doCreateAction(DoCrudVo inputVo) {

        Company company = new Company();
        company.setAddress(inputVo.getCompanyAddress());
        company.setName(inputVo.getCompanyName());
        company.setCreatedBy(inputVo.getUserId());
        company.setCreatedDate(new Date());
        companyRepository.save(company);

        Client client = new Client();
        client.setCompanyId(company.getId());
        client.setName(inputVo.getClientName());
        client.setPhone(inputVo.getClientPhone());
        client.setEmail(inputVo.getClientEmail());
        client.setCreatedBy(inputVo.getUserId());
        client.setCreatedDate(new Date());
        clientRepository.save(client);

    }

    public ResultVo update(DoCrudVo inputVo) {
        ResultVo resultVo = new ResultVo();

        try {
            checkCrudBasicInputValid(resultVo, inputVo, CRUD.UPDATE);
            checkUpdateInputLimit(resultVo, inputVo);

            if (resultVo.getStatus() == ActionResultStatus.SUCCESS) {
                doUpdateAction(resultVo, inputVo);
            }
        } catch (Exception e) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(e.toString());
        }

        return resultVo;
    }

    public void doUpdateAction(ResultVo resultVo, DoCrudVo inputVo) {
        if (inputVo.getCompanyId() != null) {
            Company company = companyRepository.findById(inputVo.getCompanyId()).orElse(null);
            if (company != null) {
                company.setAddress(inputVo.getCompanyAddress());
                company.setName(inputVo.getCompanyName());
                company.setUpdateBy(inputVo.getUserId());
                company.setUpdatedDate(new Date());
                companyRepository.save(company);
            } else {
                resultVo.setStatus(ActionResultStatus.WARNING);
                resultVo.setErrorMsg(COMPANY_ID_NOT_EXIST_IN_DB);
            } 
        }

        if (inputVo.getClientId() != null) {
            Client client = clientRepository.findById(inputVo.getClientId()).orElse(null);
            if (client != null) {
                client.setEmail(inputVo.getClientEmail());
                client.setName(inputVo.getClientName());
                client.setPhone(inputVo.getClientPhone());
                client.setUpdatedBy(inputVo.getUserId());
                client.setUpdatedDate(new Date());
                clientRepository.save(client);
            } else {
                resultVo.setStatus(ActionResultStatus.WARNING);
                resultVo.setErrorMsg(CLIENT_ID_NOT_EXIST_IN_DB);
            }
            
        }
    }


    public void checkUpdateInputLimit(ResultVo resultVo, DoCrudVo inputVo) {
        if (inputVo.getCompanyId() == null && inputVo.getClientId() == null) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(VIOLATE_UPDATE_RULE);
        }
    }

    public ReadVo read(DoCrudVo inputVo) {
        ReadVo resultVo = new ReadVo();
        try {
            checkCrudBasicInputValid(resultVo, inputVo, CRUD.READ);

            if (resultVo.getStatus() == ActionResultStatus.SUCCESS) {
                doReadAction(resultVo);
            }

        } catch (Exception e) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(e.toString());
        }

        return resultVo;
    }

    public void doReadAction(ReadVo resultVo) {
        resultVo.setCompanyList(companyRepository.findAll());
        resultVo.setClientList(clientRepository.findAll());

    }

    public ResultVo delete(DoCrudVo inputVo) {
        ResultVo resultVo = new ResultVo();

        try {
            checkCrudBasicInputValid(resultVo, inputVo, CRUD.DELETE);

            if (resultVo.getStatus() == ActionResultStatus.SUCCESS) {
                doDeleteAction(inputVo);
            }

        } catch (Exception e) {
            resultVo.setStatus(ActionResultStatus.FAIL);
            resultVo.setErrorMsg(e.toString());
        }

        return resultVo;
    }

    public void doDeleteAction(DoCrudVo inputVo) {

        if (inputVo.getCompanyId() != null) {
            companyRepository.deleteById(inputVo.getCompanyId());
        }

        if (inputVo.getClientId() != null) {
            clientRepository.deleteById(inputVo.getClientId());
        }

    }

}
