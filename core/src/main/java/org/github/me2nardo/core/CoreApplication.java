package org.github.me2nardo.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by leo on 20.12.16.
 */
@SpringBootApplication
public class CoreApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CoreApplication.class)
        .run(args);
    }
}
