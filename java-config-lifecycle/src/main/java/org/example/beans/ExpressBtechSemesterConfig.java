package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpressBtechSemesterConfig {

    @Bean
    public ExpressBtechSemester expressBtechSemester() {
        return new ExpressBtechSemester();
    }
}
