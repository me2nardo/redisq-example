package org.github.me2nardo.producer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by leo on 20.12.16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.github.me2nardo.core.config"})
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class);
    }
}
