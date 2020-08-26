package com.dekapx.springboot.core.processor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloWorldITest {
    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void shouldCallHelloWorldPostProcessor() {
        String result = helloWorld.sayHello("DeKapx");
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("Hello ! DeKapx");
    }
}
