package com.example.data_service.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class Country {
    @Id
    public Long id;
    @Column(name = "value")
    public String value;

    public Country() {}
}
