package com.user.user.model;

public class Response {

    private String error;
    public Response(){}
    public Response(String error){
        this.error=error;
    }
    public void setError(String error){
        this.error=error;
    }
    public String getError(){
        return this.error;
    }
}
