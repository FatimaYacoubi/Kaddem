package com.example.kaddemm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"esprit.tn.Entity"})
public class KaddemmApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaddemmApplication.class, args);
    }

}
