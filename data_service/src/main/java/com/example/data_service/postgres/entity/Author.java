package com.example.data_service.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    public Long id;
    @Column(name = "first_nameid")
    public Long firstNameId;
    @Column(name = "second_nameid")
    public Long secondNameId;

    public Author() {}
}
