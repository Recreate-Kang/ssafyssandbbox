package com.ssafy.sandbox.smtp.dto;

import lombok.Data;

@Data
public class ResponseSendCode {

    Boolean isOk;

    public static ResponseSendCode pass() {
        ResponseSendCode res = new ResponseSendCode();
        res.isOk = true;
        return res;
    }

    public static ResponseSendCode fail() {
        ResponseSendCode res = new ResponseSendCode();
        res.isOk = false;
        return res;
    }
}
