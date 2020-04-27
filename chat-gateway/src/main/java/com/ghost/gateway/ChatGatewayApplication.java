package com.ghost.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ChatGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatGatewayApplication.class, args);
    }

}
