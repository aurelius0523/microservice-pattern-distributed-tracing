package com.aurelius.demo.sleuth.dao.postgres.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class UserEntity {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
