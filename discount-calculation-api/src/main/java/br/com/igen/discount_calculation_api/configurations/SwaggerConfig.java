package br.com.igen.discount_calculation_api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.annotations.RouterOperation;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Cálculo de Desconto")
                .version("1.0")
                .description("Documentação da API para cálculo de descontos em ingressos")
                .contact(new Contact().name("Mariana").email("mariana.dsm@hotmail.com")));
    }
}
