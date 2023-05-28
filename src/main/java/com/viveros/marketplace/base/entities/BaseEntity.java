package com.viveros.marketplace.base.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    private void antesDePersistir(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDelUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
