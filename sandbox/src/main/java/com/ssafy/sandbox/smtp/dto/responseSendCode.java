package com.ssafy.sandbox.smtp.dto;

import lombok.Data;

@Data
public class responseSendCode {

    Boolean isOk;

    public static responseSendCode pass(){
        responseSendCode res = new responseSendCode();
        res.isOk = true;
        return res;
    }
    public  static responseSendCode fail(){
        responseSendCode res = new responseSendCode();
        res.isOk = false;
        return res;
    }
}
