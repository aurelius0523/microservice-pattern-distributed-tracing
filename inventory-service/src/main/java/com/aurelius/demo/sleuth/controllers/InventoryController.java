package com.aurelius.demo.sleuth.controllers;

import com.aurelius.demo.sleuth.dao.postgres.UserRepository;
import com.aurelius.demo.sleuth.dao.postgres.entities.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    public InventoryController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private final UserRepository userRepository;

    @GetMapping
    public String getInventory() {
        List<UserEntity> userEntities = userRepository.findAll();

        userEntities.forEach((userEntity -> System.out.println(userEntity.getName())));
        return "sticky notes";
    }
}
