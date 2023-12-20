package com.example.data_service.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class AuthorNew {
    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "first_nameid")
    public FirstName firstName;

    @ManyToOne
    @JoinColumn(name = "second_nameid")
    public SecondName secondName;

    public AuthorNew() {}
}
