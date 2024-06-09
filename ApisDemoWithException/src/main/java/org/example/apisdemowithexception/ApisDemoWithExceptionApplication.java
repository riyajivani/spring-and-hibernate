package org.example.apisdemowithexception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApisDemoWithExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApisDemoWithExceptionApplication.class, args);
    }

}
