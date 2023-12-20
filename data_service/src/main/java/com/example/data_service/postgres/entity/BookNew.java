package com.example.data_service.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class BookNew {
    @Id
    public Long id;

    @Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "countryid")
    public Country country;

    @ManyToOne
    @JoinColumn(name = "authorid")
    public AuthorNew authorNew;

    @ManyToOne
    @JoinColumn(name = "genreid")
    public Genre genre;

    public BookNew() {}
}
