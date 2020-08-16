package com.spring.mvc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.function.Function;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class AppWebConfig implements WebMvcConfigurer {

    @Autowired
    private FunctionController handler;

    private Function<ServerRequest, ServerRequest> function = req -> {
        System.out.println("Before path");
        return req;
    };

    @Autowired
    private FunctionControllerAdvice functionControllerAdvice;

    @Bean
    public RouterFunction<ServerResponse> router(){
        RouterFunction<ServerResponse> route = route()
                .path("/person", builder -> builder
                        .GET("/{id}", accept(APPLICATION_JSON), handler::getPerson)
                        .GET("", accept(APPLICATION_JSON), handler::listPeople)
                        .before(function)
                        .after((req, res) -> {
                            System.out.println("After path");
                            return res;
                        })
                        .filter((request, next) -> {
                            System.out.println("Filter path...");
                            return next.handle(request);
                        })
                )
                .POST("/person", handler::createPerson)
                .before(functionControllerAdvice::beforeProcess)
                .after((req, res) -> {
                    System.out.println("After all");
                    return res;
                })
                .filter((request, next) -> {
                    System.out.println("Filter all...");
                    return next.handle(request);
                })
                .build();

        return route;
    }
}
