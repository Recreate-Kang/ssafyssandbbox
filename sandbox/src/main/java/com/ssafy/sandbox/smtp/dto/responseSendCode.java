package com.ssafy.sandbox.smtp.dto;

import lombok.Data;

@Data
public class responseSendCode {

    boolean isSuccess;

    public static responseSendCode pass(){
        responseSendCode res = new responseSendCode();
        res.isSuccess = true;
        return res;
    }
    public  static responseSendCode fail(){
        responseSendCode res = new responseSendCode();
        res.isSuccess = false;
        return res;
    }
}
