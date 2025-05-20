package com.anikanov02.selfhost;

import com.anikanov02.selfhost.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class AiServerApp {
    public static void main(String[] args) {
        SpringApplication.run(AiServerApp.class, args);
    }
}