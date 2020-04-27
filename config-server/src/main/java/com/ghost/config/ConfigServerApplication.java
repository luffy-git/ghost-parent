package com.ghost.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p>
 *  配置中心启动类
 *  EnableConfigServer 标识 为配置中心服务端
 * </p>
 * @author luffy
 * @since 2020-03-21 18:36:09
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
