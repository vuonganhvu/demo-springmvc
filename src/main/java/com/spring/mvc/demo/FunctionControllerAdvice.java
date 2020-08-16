package com.spring.mvc.demo;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

@Component
public class FunctionControllerAdvice {

    public ServerRequest beforeProcess(ServerRequest request){
        System.out.println("Before all");
        return request;
    }

    public ServerRequest afterProcess(ServerRequest request){
        System.out.println("Before all");
        return request;
    }

}
