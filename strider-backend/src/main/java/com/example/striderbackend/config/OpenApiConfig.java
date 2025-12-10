package com.example.striderbackend.config;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
 @Bean
 public OpenAPI api(){
  return new OpenAPI().info(new Info()
    .title("Strider Backend API")
    .version("1.0.0")
    .description("REST API for Strider.")
    .contact(new Contact().name("Strider").email("support@strider.dev"))
    .license(new License().name("Apache 2.0")));
 }
}