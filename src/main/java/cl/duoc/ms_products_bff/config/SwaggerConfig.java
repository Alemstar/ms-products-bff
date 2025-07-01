package cl.duoc.ms_products_bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI() 
                   .info(new Info().title("Products microservice - Backend for Frontend (BFF) Documentation.")
                                    .description("This microservice acts as an intermediate layer to handle the information received from the database and the business logic.")
                                    .version("1.0"));
    }

}
