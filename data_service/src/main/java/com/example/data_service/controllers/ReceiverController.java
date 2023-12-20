package com.example.data_service.controllers;

import com.example.data_service.dto.AuthorDto;
import com.example.data_service.dto.BookDto;
import com.example.data_service.postgres.entity.FirstName;
import com.example.data_service.postgres.repository.AuthorNewRepository;
import com.example.data_service.postgres.repository.BookNewRepository;
import com.example.data_service.postgres.repository.FirstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/receiver")
public class ReceiverController {

    @Autowired
    AuthorNewRepository authorNewRepository;
    @Autowired
    BookNewRepository bookNewRepository;
    @Autowired
    FirstNameRepository firstNameRepository;

    @GetMapping("/getAuthorsByFirstName")
    public List<AuthorDto> getAuthorsByFirstName(@RequestParam(value = "firstName") String firstName) {
        return authorNewRepository.findAllAuthorsByFirstName(firstName)
                .stream()
                .map(author -> new AuthorDto(author.getFirstName().getValue(), author.getSecondName().getValue()))
                .toList();
    }

    @GetMapping("/getBooksByCountry")
    public List<BookDto> getBooksByCountry(@RequestParam(value = "country") String country) {
        return bookNewRepository.findAllBooksByCountry(country)
                .stream()
                .map(book -> new BookDto(book.getName(), book.authorNew.getFirstName().getValue(), book.authorNew.getSecondName().getValue(), book.getCountry().getValue(), book.getGenre().getValue()))
                .toList();
    }

    @GetMapping("/getAllFirstNames")
    public List<String> getAllFirstNames() {
        return firstNameRepository.findAll()
                .stream()
                .map(FirstName::getValue)
                .toList();
    }
}