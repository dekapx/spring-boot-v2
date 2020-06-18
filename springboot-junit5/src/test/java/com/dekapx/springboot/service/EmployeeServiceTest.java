package com.dekapx.springboot.service;

import com.dekapx.springboot.dao.EmployeeDao;
import com.dekapx.springboot.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
@DisplayName("JUnit5 tests for EmployeeService")
public class EmployeeServiceTest {
    @Mock
    private EmployeeDao employeeDaoMock;

    @InjectMocks
    private EmployeeServiceImpl employeeService; // expect implementation for inject mocks, doesn't work with interface

    @BeforeEach
    private void setup() {
        initMocks(this);
        when(employeeDaoMock.findOne(anyLong())).thenAnswer(
                (invocationOnMock) -> Employee.builder().id(1L).name("Dummy").build());
    }

    @Test
    @DisplayName("find an employee by id")
    public void findsById() {
        Employee employee = employeeService.findOne(1L);
        assertAll(
                () -> assertNotNull(employee),
                () -> assertEquals(1L, employee.getId()),
                () -> assertEquals("Dummy", employee.getName())
        );
        verify(employeeDaoMock).findOne(anyLong());
    }
}
