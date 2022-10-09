package com.example.demo;

import com.example.demo.service.RegistrationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Getter @Setter
public class DemoApplication implements CommandLineRunner {

    @Autowired
    RegistrationService registrationService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        registrationService.register();

        System.out.println("Finished");
    }
}
