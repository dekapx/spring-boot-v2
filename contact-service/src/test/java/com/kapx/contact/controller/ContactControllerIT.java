package com.kapx.contact.controller;

import com.kapx.contact.domain.Contact;
import com.kapx.contact.vo.ContactVO;
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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
        contact.setPhone("123456789");
        contact.setEmail("dekapx@kapxinc.com");
    }

    @Test
    public void getContactById() throws Exception {
        final URL base = new URL("http://localhost:" + port + "/contact/find/1");
        ResponseEntity<ContactVO> response = template.getForEntity(base.toString(), ContactVO.class);
        final ContactVO contactVO = response.getBody();
        assertThat(contactVO, is(notNullValue()));
        assertThat(contactVO.getFirstName(), is(equalTo("De")));
        assertThat(contactVO.getLastName(), is(equalTo("Kapx")));
    }
}
