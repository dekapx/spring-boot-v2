package com.dimensiondata.cloud.monitoring;

import com.dimensiondata.cloud.preference.domain.UserPreference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PreferenceRestAdapter {

    public UserPreference findPreferenceByUserId(final String userId) {
        UserPreference preference = null;

        try {
            final String URI = "http://localhost:8080/pref/find/" + userId;
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(URI);
            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
            final String jsonResponse = bufferedReader.readLine();
            final ObjectMapper objectMapper = new ObjectMapper();
            preference = objectMapper.readValue(jsonResponse, UserPreference.class);
            return preference;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return preference;
    }
}
