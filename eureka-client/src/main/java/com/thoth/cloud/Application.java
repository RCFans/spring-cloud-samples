package com.thoth.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: Justina Chen
 * Date: 2/26/16
 * Time: 1:27 AM
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String home() {
        return "This is eureka client.";
    }

    @RequestMapping("/list")
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("WELCOME");
        if (list != null && list.size() > 0 ) {
            return "Found: " + list.get(0).getServiceId() + list.get(0).getUri().toString();
        }
        return "Found nothing.";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
