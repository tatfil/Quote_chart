package org.example.config;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chart() {
        return GroupedOpenApi.builder().group("quote-chart")
//                .addOperationCustomizer((operation, handlerMethod) -> {
//                   // operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
//                    return operation;
//                })
                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Users API").version("1")))
                .packagesToScan("org.example")
                .build();
    }


}