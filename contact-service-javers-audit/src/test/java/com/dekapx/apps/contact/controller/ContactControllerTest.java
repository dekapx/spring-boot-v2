package com.dekapx.apps.contact.controller;

import com.dekapx.apps.contact.model.ContactModel;
import com.dekapx.apps.contact.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.function.Supplier;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactController.class)
public class ContactControllerTest {
    private static final Long ID = 1L;
    private static final String FIRST_NAME = "Test";
    private static final String LAST_NAME = "User";
    private static final String EMAIL = "testuser@google.com";
    private static final String PHONE = "+1 (123) 456 7890";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactServiceMock;

    @Test
    public void shouldReturnAllContacts() throws Exception {
        given(contactServiceMock.findAll()).willReturn(contactSupplier.get());
        this.mockMvc.perform(get("/api/contacts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].firstName", is(FIRST_NAME)))
                .andExpect(jsonPath("$[0].lastName", is(LAST_NAME)))
                .andExpect(jsonPath("$[0].email", is(EMAIL)))
                .andExpect(jsonPath("$[0].phone", is(PHONE)));
    }

    @Test
    public void shouldReturnContactById() throws Exception {
        given(contactServiceMock.findById(ID)).willReturn(buildContactModel());
        this.mockMvc.perform(get("/api/contact/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is(FIRST_NAME)))
                .andExpect(jsonPath("$.lastName", is(LAST_NAME)))
                .andExpect(jsonPath("$.email", is(EMAIL)))
                .andExpect(jsonPath("$.phone", is(PHONE)));
    }

    private Supplier<List<ContactModel>> contactSupplier = () -> List.of(buildContactModel());

    private ContactModel buildContactModel() {
        return ContactModel.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .phone(PHONE)
                .build();
    }
}