package org.example.restaurant.infra.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import io.swagger.v3.oas.models.info.Info

@Configuration
@EnableAspectJAutoProxy
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .addSecurityItem(
                SecurityRequirement().addList("Bearer Authentication")
            )
            .components(
                Components().addSecuritySchemes(
                    "Bearer Authentication",
                    SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("Bearer")
                        .bearerFormat("JWT")
                        .`in`(SecurityScheme.In.HEADER)
                        .name("Authorization")
                )
            )
            .info(
                Info()
                    .title("restaurantMap API")
                    .description("restaurantMap API schema")
                    .version("1.0.0")
            )
    }
}