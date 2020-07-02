package com.dekapx.springboot.controller;

import com.dekapx.springboot.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/employee/id/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(getEmployee())))
                .andExpect(status().isOk());
    }

    private Employee getEmployee() {
        return Employee.builder()
                .id(1L)
                .name("Dummy")
                .build();
    }
}
