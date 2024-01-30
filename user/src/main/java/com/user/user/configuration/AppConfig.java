package com.user.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class AppConfig {
    @Bean
    public Dotenv dotenv(){
        return Dotenv.configure().load();
    }
    public String getDBURI(){
        return dotenv().get("DB_URL");
    }
}
