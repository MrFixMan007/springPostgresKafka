package com.example.api_service.controller;

import com.example.api_service.dto.AuthorDto;
import com.example.api_service.dto.BookDto;
import com.example.api_service.service.KafkaSenderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WebController {

    @Autowired
    KafkaSenderExample kafkaSenderExample;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/addFirstName")
    private String hello(@RequestParam(value = "firstName") String firstName) {
        kafkaSenderExample.sendMessage(firstName, "demo_topic");
        return "Запрос отправлен";
    }

    @GetMapping("/getAuthorsByFirstName")
    private List<AuthorDto> getAuthorsByFirstName(@RequestParam(value = "firstName") String firstName) {
        String receiverUrl = "http://data-service:8080/receiver/getAuthorsByFirstName?firstName="+firstName;
        ResponseEntity<List<AuthorDto>> responseEntity = restTemplate.exchange(receiverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<AuthorDto>>() {});
        return responseEntity.getBody();
    }

//    @GetMapping("/getBooksByCountry")
//    private List<BookDto> getBooksByCountry(@RequestParam(value = "country") String country) {
//        String receiverUrl = "http://data-service:8080/receiver/getBooksByCountry?country="+country;
//        ResponseEntity<List<BookDto>> responseEntity = restTemplate.exchange(receiverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<BookDto>>() {});
//        return responseEntity.getBody();
//    }

    @GetMapping("/getBooksByCountry")
    private ModelAndView getBooksByCountry(@RequestParam(value = "country") String country) {
        String receiverUrl = "http://data-service:8080/receiver/getBooksByCountry?country="+country;
        ResponseEntity<List<BookDto>> responseEntity = restTemplate.exchange(receiverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<BookDto>>() {});

        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", responseEntity.getBody());

        return modelAndView;
    }

//    @GetMapping("/getAllFirstNames")
//    private List<String> getAllFirstNames() {
//        String receiverUrl = "http://data-service:8080/receiver/getAllFirstNames";
//        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(receiverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
//        return responseEntity.getBody();
//    }

    @GetMapping("/getAllFirstNames")
    private ModelAndView getAllFirstNames() {
        String receiverUrl = "http://data-service:8080/receiver/getAllFirstNames";
        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(receiverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});

        ModelAndView modelAndView = new ModelAndView("first_names");
        modelAndView.addObject("firstNames", responseEntity.getBody());

        return modelAndView;
    }

}
