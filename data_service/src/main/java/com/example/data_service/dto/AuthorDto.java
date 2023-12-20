package com.example.data_service.dto;

import com.example.data_service.postgres.entity.FirstName;
import com.example.data_service.postgres.entity.SecondName;
import lombok.Data;

@Data
public class AuthorDto {
    public String firstName;
    public String secondName;

    public AuthorDto(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
