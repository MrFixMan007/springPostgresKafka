package com.example.data_service.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "first_names")
public class FirstName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "value")
    public String value;

    public FirstName() {}
}
