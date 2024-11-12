package com.ssafy.sandbox.smtp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class responseVerification{
    Boolean isSuccess;

    public static responseVerification pass(){
        responseVerification res = new responseVerification();
        res.isSuccess = true;
        return res;
    }
    public  static responseVerification fail(){
        responseVerification res = new responseVerification();
        res.isSuccess = false;
        return res;
    }
}
