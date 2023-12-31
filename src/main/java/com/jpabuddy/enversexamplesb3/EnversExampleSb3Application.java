package com.jpabuddy.enversexamplesb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;

@SpringBootApplication
@EnableEnversRepositories
public class EnversExampleSb3Application{

    public static void main(String[] args) {
        SpringApplication.run(EnversExampleSb3Application.class, args);
    }
}
