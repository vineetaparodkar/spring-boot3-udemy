package com.example.springbootcrudrestapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "spring boot rest api doc"
                , description = ""
                , version = "1.0.0"
                , contact = @Contact(
                name = "",
                email = "",
                url = ""
        ),
                license = @License(
                        name = "Apache 2.0",
                        url = ""
                )
        ),
        externalDocs = @ExternalDocumentation(description = "user management documentation",
                url = ""
        )
)
public class SpringBootCrudRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudRestApiApplication.class, args);
    }

}
