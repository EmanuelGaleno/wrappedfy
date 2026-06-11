package com.duell.wrappedfy.infrastructure.spotify.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI wrappedfyOpenApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Wrappedfy API")
                                .description("API responsável pela geração de estatísticas personalizadas do Spotify.")
                                .version("v1")
                                .contact(
                                        new Contact()
                                                .name("Duell")
                                )
                );
    }
}