package com.example.Section1_MicroServices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservices REST API Documentation",
		         description = "SimpleBank Accounts microservices REST API Documentation",
				version="v1",
				contact = @Contact(
						name="Sohan Prasad",
						email = "sohan@123",
						url="https://springdoc.org/"//or our project
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://springdoc.org/"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "SimpleBank Accounts microservices REST API Documentation",
				url="http://localhost:8080/swagger-ui/index.html"
		)

)
public class Section1MicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section1MicroServicesApplication.class, args);
	}

}
