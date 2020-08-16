package com.spring.mvc.demo;


import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class FunctionController {

    public ServerResponse listPeople(ServerRequest request) throws Exception {
        // ...
        throw new Exception("fdfs");
//        return ServerResponse.accepted().body("OK");
    }

    public ServerResponse createPerson(ServerRequest request) throws ServletException, IOException {
        // ...
//        Person person = request.body(new ParameterizedTypeReference<Person>() {});
        Person person = request.body(Person.class);
        return ServerResponse.accepted().contentType(MediaType.APPLICATION_JSON).body(person);
    }

    public ServerResponse getPerson(ServerRequest request) {
        // ...
        Map<String, String>  pathParam = new HashMap<>();
        pathParam = request.pathVariables();
        return ServerResponse.accepted().body("OK " + pathParam.get("id"));
    }
}
