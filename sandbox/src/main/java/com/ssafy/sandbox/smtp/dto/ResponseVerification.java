package com.ssafy.sandbox.smtp.dto;

import lombok.Getter;

@Getter
public class ResponseVerification {
    Boolean isSuccess;

    public static ResponseVerification pass() {
        ResponseVerification res = new ResponseVerification();
        res.isSuccess = true;
        return res;
    }

    public static ResponseVerification fail() {
        ResponseVerification res = new ResponseVerification();
        res.isSuccess = false;
        return res;
    }
}
