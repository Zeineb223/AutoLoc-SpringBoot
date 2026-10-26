package tn.esprit.autoloc.web.controller;
import org.springframework.context.annotation.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration public class OpenApiConfig { @Bean public OpenAPI autolocOpenApi() { return new OpenAPI().info(new Info().title("AutoLoc API").description("API REST de gestion de location de véhicules").version("1.0.0")); } }
