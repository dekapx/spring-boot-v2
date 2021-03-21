package com.dekapx.springboot.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

@Service
public class PingServiceQueryResolver implements GraphQLQueryResolver {
    public String hello() {
        return "Hello, GraphQL!";
    }
}
