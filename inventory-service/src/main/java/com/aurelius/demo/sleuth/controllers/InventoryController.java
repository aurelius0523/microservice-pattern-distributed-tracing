package com.aurelius.demo.sleuth.controllers;

import com.aurelius.demo.sleuth.dao.mongo.InventoryRepository;
import com.aurelius.demo.sleuth.dao.mongo.entities.InventoryEntity;
import com.aurelius.demo.sleuth.dao.postgres.UserRepository;
import com.aurelius.demo.sleuth.dao.postgres.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getInventory() {
        List<InventoryEntity> inventoryEntityList = inventoryRepository.findAll();

        inventoryEntityList
                .stream()
                .forEach(System.out::println);

        List<UserEntity> userEntities = userRepository.findAll();

        userEntities.stream()
                .forEach(System.out::println);
        return "sticky notes";
    }
}
