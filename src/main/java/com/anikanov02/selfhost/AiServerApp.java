package com.anikanov02.selfhost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 * 1. Custom exceptions with error codes
 * 2. Exception handling, 401, 403 etc.
 */
@SpringBootApplication
public class AiServerApp {
    public static void main(String[] args) {
        SpringApplication.run(AiServerApp.class, args);
    }
}