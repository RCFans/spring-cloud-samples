package com.thoth.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Justina Chen
 * Date: 2/26/16
 * Time: 1:02 AM
 */

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class HelloApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello World 2";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
