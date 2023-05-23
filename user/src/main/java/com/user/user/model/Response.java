package com.user.user.model;

import org.springframework.http.HttpStatus;

public class Response {
    private Object body;
    private HttpStatus status;

    public Response(Object body, HttpStatus status){
        this.body=body;
        this.status=status;
    }
    public Object getBody(){
        return this.body;
    }
    public HttpStatus getStatus(){
        return this.status;
    }
    @Override
    public String toString(){
        return "{Object:"+this.body+", status:"+this.status;
    }
}
