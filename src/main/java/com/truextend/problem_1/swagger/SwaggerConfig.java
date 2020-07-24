package com.truextend.problem_1.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.truextend.problem_1.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(swaggerInfo());
    }

    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder()
                .title("Problem 1")
                .description("REST API for a system that assigns students to classes")
                .build();
    }

}
