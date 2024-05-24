package com.entidades.buenSabor.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("El Buen Sabor - Grupo 10")
                        .version("v 1.12")
                        .description("Proyecto final <b>\"El Buen Sabor\"</b> E-Commerce de empresas gastronomicas. </br> API documentada mediante Swagger UI" +
                                "<h3> Integrantes</h3>" +
                                "<ul> <li> Giuliano Espejo (Back-End) </li> <li> Gonzalo Herrera (Back-End) </li> <li> Sophia Alvarez (Front-End)</li>  <li> Francisco Lazaro (Front-End)</li> </ul>")
                        .contact(new Contact()
                                .name("Grupo 10"))
                        .contact(new Contact()
                                .name("Github")
                                .url("https://github.com/gonzaaherre/BuenSaborBack2")
                        )
                );
    }
}