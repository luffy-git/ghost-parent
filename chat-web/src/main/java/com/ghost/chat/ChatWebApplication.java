package com.ghost.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ChatWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatWebApplication.class, args);
    }

}
