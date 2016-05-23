package com.nsshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DaichiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaichiApplication.class, args);
    }
}
