package com.dekapx.apps.contact.graphql;

import com.dekapx.apps.contact.domain.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQLTest {

    @Test
    public void invokeGraphQL() throws Exception {
        final RestTemplate restTemplate = new RestTemplate();
        final String query = getJsonString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer *************");
        headers.add("content-type", "application/graphql");
        final String graphURL = "http://localhost:9091/graphql";
        ResponseEntity<String> response = restTemplate.postForEntity(graphURL, new HttpEntity<>(query, headers), String.class);
        assertThat(response).isNotNull();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Collection<Contact> contacts = objectMapper.readValue(response.getBody(), new TypeReference<Collection<Contact>>(){});
        log.info(response.getBody());
    }

    private String getJsonString() {
        final String jsonString = "{ \n" +
                "    findContacts { \n" +
                "        firstName\n" +
                "        lastName\n" +
                "        email\n" +
                "        phone\n" +
                "    } \n" +
                "}";
        return jsonString;
    }
}
