package com.anikanov02.selfhost.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
    private String frontendBaseUrl;
}
