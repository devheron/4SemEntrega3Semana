package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// ESCANEAR O PACOTE DAS CLASSES E PRODUTO
@SpringBootApplication
@EnableJpaRepositories(basePackages = "app.repository")
@EntityScan(basePackages = "app.entity")
public class SistemavendasApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemavendasApplication.class, args);
    }
}