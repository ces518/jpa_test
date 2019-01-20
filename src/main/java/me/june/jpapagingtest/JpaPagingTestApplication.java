package me.june.jpapagingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "me.june.*")
@EntityScan("me.june.entity")
@EnableJpaRepositories("me.june.repository")
public class JpaPagingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaPagingTestApplication.class, args);
    }

}
