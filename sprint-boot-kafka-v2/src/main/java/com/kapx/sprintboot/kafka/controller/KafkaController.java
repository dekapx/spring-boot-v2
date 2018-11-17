package com.kapx.sprintboot.kafka.controller;

import com.kapx.sprintboot.kafka.model.CustomMessage;
import com.kapx.sprintboot.kafka.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/api/v2")
public class KafkaController {
    private Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "/ping", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String ping() {
        logger.info("Hi! this URL is active...");
        sendMessage(new CustomMessage("Notification", "Message for Kafka Broker"));
        return "Hi! this URL is active...";
    }

    @PostMapping(value = "/sendMessage", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private void sendMessage(@RequestBody final CustomMessage customMessage) {
        logger.info("sending message to kafkaProducer...");
        kafkaProducer.send(customMessage);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
