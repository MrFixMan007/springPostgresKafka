package com.example.data_service.service;

import com.example.data_service.postgres.entity.FirstName;
import com.example.data_service.postgres.repository.FirstNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListenersExample {

    private final FirstNameRepository nameRepository;

    @Autowired
    public KafkaListenersExample(FirstNameRepository nameRepository){
        this.nameRepository = nameRepository;
    }

    @KafkaListener(topics = "demo_topic", groupId = "myGroup")
    void listener(String data) {
        FirstName firstName = new FirstName();
        firstName.value = data;
        nameRepository.save(firstName);

        System.out.println(data);
        System.out.println(nameRepository.findAll());

    }

}