package com.user.user.model;

import com.user.user.interfaces.Results;

public class Error implements Results{

    private String error;
    public Error(){}
    public Error(String error){
        this.error=error;
    }
    public void setError(String error){
        this.error=error;
    }
    public String getError(){
        return this.error;
    }
}
