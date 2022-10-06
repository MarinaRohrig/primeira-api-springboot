package br.com.futurodev.primeiraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // Roda o projeto java spring boot , recebe uma classe
        SpringApplication.run(Application.class, args);
    }
}
