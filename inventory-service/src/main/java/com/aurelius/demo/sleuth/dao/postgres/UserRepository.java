package com.aurelius.demo.sleuth.dao.postgres;

import com.aurelius.demo.sleuth.dao.postgres.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
