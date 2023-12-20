package com.example.api_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderExample {

    private final KafkaTemplate<String, String> kafkaTemplate;
//    private final KafkaTemplate<BookDto, String> kafkaTemplateBook;

    @Autowired
    KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate/*, KafkaTemplate<BookDto, String> kafkaTemplateBook*/) {
        this.kafkaTemplate = kafkaTemplate;
//        this.kafkaTemplateBook = kafkaTemplateBook;
    }

    public void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
//
//    public void sendBook(BookDto book, String topicName) {
//        kafkaTemplateBook.send(topicName, topicName);
//    }

}