package com.aurelius.demo.sleuth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping
    public String getEmployeeDetail() {
        String response = (String) restTemplate.exchange("http://localhost:8081/inventories",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }).getBody();
        return response;
    }
}
