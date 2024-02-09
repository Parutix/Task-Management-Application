package org.example.tmabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class TmaBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(TmaBackendApplication.class, args);
    }


}
