package com.inditex.store.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = { "com.inditex.store.service.dataaccess", "com.inditex.dataaccess"})
@EntityScan(basePackages = { "com.inditex.store.service.dataaccess", "com.inditex.dataaccess" })
@SpringBootApplication(scanBasePackages = "com.inditex")
public class StoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreServiceApplication.class,args);
    }
}
