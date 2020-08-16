package com.spring.mvc.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonalController {

//    @GetMapping("/person")
//    public ResponseEntity getListPerson(){
//        return ResponseEntity.ok("Get List person");
//    }

    @GetMapping("/person/{id}")
    public ResponseEntity getPerson(@PathVariable("id") String id) throws Exception{
        throw new Exception(id);
    }
}
