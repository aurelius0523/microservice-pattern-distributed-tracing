package com.aurelius.demo.sleuth.dao.mongo;

import com.aurelius.demo.sleuth.dao.mongo.entities.InventoryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<InventoryEntity, ObjectId> {
}
