package com.aurelius.demo.sleuth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employees")
@EnableConfigurationProperties
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${demo.rest.inventory.url}")
    private String inventoryUrl;

    @GetMapping
    public String getEmployeeDetail() {
        return restTemplate.exchange( inventoryUrl, HttpMethod.GET, null, new ParameterizedTypeReference<String>() { })
                .getBody();
    }
}
