package com.kapx.contact.controller;

import com.kapx.contact.vo.ContactVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ContactController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @RequestMapping(value = "/contact/{id}", method = GET)
    public ContactVO getContact(@PathVariable final Long id) {
        LOGGER.info("--- getContact REST requestfor ID {} ---", id);
        final ContactVO contactVO = new ContactVO.ContactBuilder()
                .withFirstName("De")
                .withLastName("Kapx")
                .withPhone("123456789")
                .withEmail("dekapx@kapxinc.com")
                .build();
        return contactVO;
    }

    @RequestMapping(value = "/ping", method = GET)
    public String ping() {
        LOGGER.info("--- Contact Service REST Controller ping method invoked. ---");
        return "Contact Service REST Controller";
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(Exception e) {
        return e.getMessage();
    }

//    produces = {"application/json", "application/xml"},
//    consumes = {"application/json", "application/xml"}
}
