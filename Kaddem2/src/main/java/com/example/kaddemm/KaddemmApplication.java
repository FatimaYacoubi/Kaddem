package com.example.kaddemm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = {"esprit.tn.Entity"})
@ComponentScan(basePackages = {"esprit.tn.Controller","esprit.tn.Service"})
@EnableJpaRepositories(basePackages = {"esprit.tn.Repository"})
public class KaddemmApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaddemmApplication.class, args);
    }

}
