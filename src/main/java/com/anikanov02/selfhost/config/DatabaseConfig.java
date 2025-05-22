package com.anikanov02.selfhost.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.anikanov02.selfhost.domain.entity")
@EnableJpaRepositories("com.anikanov02.selfhost.repository")
@EnableJpaAuditing
public class DatabaseConfig {
}
