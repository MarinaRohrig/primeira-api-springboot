package br.com.futurodev.primeiraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone(("UTC")));

        // Roda o projeto java spring boot , recebe uma classe
        SpringApplication.run(Application.class, args);
    }
}
