package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Planet")
public class Planet {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;
}

