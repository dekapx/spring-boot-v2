package com.dekapx.apps.core.config;

import org.javers.spring.auditable.AuthorProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfig {
    @Bean
    public AuthorProvider provideJaversAuthor() {
        return new SimpleAuthorProvider();
    }

    private static class SimpleAuthorProvider implements AuthorProvider {
        @Override
        public String provide() {
            return "KAPIL";
        }
    }
}
