package com.tiketi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion de Tickets")
                        .version("1.0")
                        .description("Documentation de l'API de Gestion de Tickets")
                        .contact(new Contact()
                                .name("Abdou Sidibé")
                                .email("abdousidibe412@gmail.com"))); // Configuration des informations de l'API
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")
                .build(); // Groupement des APIs publiques
    }
}
