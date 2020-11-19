package com.aurelius.demo.sleuth.dao.mongo.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("inventory")
public class InventoryEntity {
    @Id
    private ObjectId id;

    private String name;

    public ObjectId getId() {
        return id;
    }

    public InventoryEntity setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public InventoryEntity setName(String name) {
        this.name = name;
        return this;
    }
}
