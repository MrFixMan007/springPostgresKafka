package com.example.data_service.dto;

import lombok.Data;

@Data
public class BookDto {
    public String name;
    public String firstName;
    public String secondName;
    public String country;
    public String genre;


    public BookDto(String name, String firstName, String secondName, String country, String genre) {
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
        this.genre = genre;
    }
}
