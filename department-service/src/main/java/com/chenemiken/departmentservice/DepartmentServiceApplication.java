package com.chenemiken.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
			title = "Department service",
			description = "Department service REST APIs documentation",
			version = "v1.0",
			contact = @Contact(
					name = "ChenemiKen",
					email = "chenemiken15@gmail.com",
					url = "github.com/ChenemiKen"
			),
			license = @License(
					name = "Apache 2.0",
					url = "github.com/ChenemiKen"
			)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department service REST APIs documentation",
				url = "github.com/ChenemiKen"
		)
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
