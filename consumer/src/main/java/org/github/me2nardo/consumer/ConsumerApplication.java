package org.github.me2nardo.consumer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

/**
 * Created by leo on 20.12.16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.github.me2nardo.core.config","org.github.me2nardo.consumer.config"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
