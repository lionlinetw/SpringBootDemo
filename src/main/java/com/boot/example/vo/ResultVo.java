package com.boot.example.vo;

import com.boot.example.Enums.ActionResultStatus;

import org.apache.logging.log4j.util.Strings;


public class ResultVo {
    private ActionResultStatus status;
    private String errorMsg;

    public ResultVo() {
        this.status = ActionResultStatus.SUCCESS;
        this.errorMsg = "";
    }

    @Override
    public String toString() {
        return "ResultVo [status=" + status + ", errorMsg=" + errorMsg + "]";
    }

    public ActionResultStatus getStatus() {
        return status;
    }

    public void setStatus(ActionResultStatus status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        if (Strings.isEmpty(this.errorMsg)) {
            this.errorMsg = errorMsg;
        } else {
            this.errorMsg += ",  " + errorMsg;
        }
    }
   
}
