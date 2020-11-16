package com.lifebyte.hubx.admin;

import com.lifebyte.hubx.cache.config.CacheServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaServer
@Import(CacheServiceConfig.class)
public class AdminMgmtServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminMgmtServiceApp.class, args);
    }
}
