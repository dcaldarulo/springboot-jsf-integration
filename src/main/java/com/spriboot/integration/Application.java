package com.spriboot.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring Boot main Application
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer
{
    public static void main( String[] args ) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
