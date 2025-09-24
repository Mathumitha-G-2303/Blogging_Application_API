package com.cypher.blog_app_apis.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig(){
        return new OpenAPI().info(new Info().title("Blogging Application APIs")
                                .description("By Mathumitha G \uFE0F")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Mathumitha G")
                                        .email("madhumitha23032005@gmail.com")
                                        .url("www.linkedin.com/in/mathumithag2616")))

                            .components(new Components().addSecuritySchemes("bearerAuth",
                                    new SecurityScheme()
                                            .name("Authorization")
                                            .type(SecurityScheme.Type.HTTP)
                                            .scheme("bearer")
                                            .in(SecurityScheme.In.HEADER)
                                            .bearerFormat("JWT")))
                            .addSecurityItem(new SecurityRequirement().addList("bearerAuth")
        );
    }
}
