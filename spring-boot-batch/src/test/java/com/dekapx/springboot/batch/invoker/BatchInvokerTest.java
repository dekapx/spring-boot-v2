package com.dekapx.springboot.batch.invoker;

import com.dekapx.springboot.batch.model.Contact;
import com.dekapx.springboot.batch.model.Status;
import com.dekapx.springboot.batch.service.ContactService;
import com.dekapx.springboot.batch.service.StatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

@SpringBootTest
public class BatchInvokerTest {
    @Autowired
    private StatusService statusService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private BatchInvoker batchInvoker;

    @Test
    public void createNewContactsAndInvokeBatch() {
//        populateData();
        batchInvoker.invoke();
    }

    private void populateData() {
        IntStream.range(1, 25).forEach(i -> consumer.accept(i));
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
}
