package com.kapx.contact.controller;

import com.kapx.contact.domain.Contact;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContactControllerIT {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void ping() throws Exception {
        final URL base = new URL("http://localhost:" + port + "/contact/ping");
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(), equalTo("Contact Service REST Controller"));
    }

    @Ignore
    @Test
    public void saveContact() throws Exception {
        final URL base = new URL("http://localhost:" + port + "/contact/save");
        final Contact contact = new Contact();
        contact.setFirstName("De");
        contact.setLastName("Kapx");
        contact.setAddress("2121, El Comino Real, San Mateo, CA");
        contact.setPhone("123456789");
        contact.setEmail("dekapx@kapxinc.com");
    }

    @Test
    public void getContactById() throws Exception {
        final URL base = new URL("http://localhost:" + port + "/contact/find/1");
        ResponseEntity<Contact> response = template.getForEntity(base.toString(), Contact.class);
        final Contact contact = response.getBody();
        assertThat(contact, is(notNullValue()));
        assertThat(contact.getFirstName(), is(equalTo("De")));
        assertThat(contact.getLastName(), is(equalTo("Kapx")));
    }
}
