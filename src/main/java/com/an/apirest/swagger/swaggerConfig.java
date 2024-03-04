package com.an.apirest.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(
        title = "API REST de Personas",
        description = "API RESTful para gestionar personas",
        version = "1.0.0",
        contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Equipo de Desarrollo", email = "contacto@example.com"),
        license = @io.swagger.v3.oas.annotations.info.License(name = "Licencia Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
))
public class swaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
    }
}
