package com.mphasis.tflms;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for OpenAPI documentation using Springdoc OpenAPI.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Creates OpenAPI configuration bean with metadata for the API documentation.
     *
     * @return OpenAPI object with metadata and license info.
     */
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