package com.kapx.sprintboot.kafka.controller;

import com.kapx.sprintboot.kafka.producer.KafkaProducer;
import com.kapx.sprintboot.kafka.producer.KafkaProducerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/api")
public class KafkaController {
    private Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "/ping", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String home() {
        logger.info("Hi! this URL is active...");
        return "Hi! this URL is active...";
    }

    @PostMapping(value = "/kafka", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String sendToTopic(@RequestBody final String message) {
        logger.info("Sending [{}] to topic...", message);
        kafkaProducer.send(message);
        return "message [" + message + "] sent...";
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
