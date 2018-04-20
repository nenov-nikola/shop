package com.store.configuration;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.store.model")
@SpringBootApplication( scanBasePackages = "com.store")
@EnableJpaRepositories(basePackages = "com.store.repository")
// @Import({SecurityConfig.class, SecurityInitializer.class})
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}
