package com.dekapx.springboot.batch.controller;

import com.dekapx.springboot.batch.invoker.BatchInvoker;
import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.model.Status;
import com.dekapx.springboot.batch.service.ContactService;
import com.dekapx.springboot.batch.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static org.springframework.http.HttpStatus.CONFLICT;

@Slf4j
@RestController
@RequestMapping("/api/batch")
public class BatchInvokerController {
    @Autowired
    private StatusService statusService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private BatchInvoker batchInvoker;

    @GetMapping(value = "/invokeBatch", produces = "application/json")
    public String invokeBatch() {
        batchInvoker.invoke();
        return "BatchInvokerController.invokeBatch() method invoked...";
    }

    @GetMapping(value = "/populateData", produces = "application/json")
    public String populateData() {
        IntStream.range(1, 25).forEach(i -> consumer.accept(i));
        return "BatchInvokerController.populateData() method invoked...";
    }

    private IntConsumer consumer = (i) -> {
        Contact contact = new Contact();
        contact.setFirstName("Test " + i);
        contact.setLastName("User");
        contact.setEmail("testUser" + i + "@demo.com");
        contact.setPhone("+353 01 234 5678");
        contact.setStatus(getPendingAuthorizedStatus());
        contactService.save(contact);
    };

    private Status getPendingAuthorizedStatus() {
        return statusService.findByStatusKey("STATUS.2");
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
