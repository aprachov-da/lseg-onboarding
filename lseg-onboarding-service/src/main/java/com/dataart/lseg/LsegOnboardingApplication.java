package com.dataart.lseg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LsegOnboardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsegOnboardingApplication.class, args);
    }
}
