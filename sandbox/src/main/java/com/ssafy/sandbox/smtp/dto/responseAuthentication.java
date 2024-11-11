package com.ssafy.sandbox.smtp.dto;

import lombok.Data;

@Data
public class responseAuthentication {

    boolean isSuccess;

    public static responseAuthentication pass(){
        responseAuthentication res = new responseAuthentication();
        res.isSuccess = true;
        return res;
    }
    public  static responseAuthentication fail(){
        responseAuthentication res = new responseAuthentication();
        res.isSuccess = false;
        return res;
    }
}
