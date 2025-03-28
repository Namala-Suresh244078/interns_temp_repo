package com.mphasis.tflms.apiconfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("File Load Management API")
                        .version("v1")
                        .description("API for managing file loads, including upload, search, and status management.")
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                );
    }
}