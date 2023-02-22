package com.exam.config;

import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static springfox.documentation.spi.service.contexts.SecurityContext.builder;

@Configuration
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER="Authorization";

    private ApiKey apiKey(){
        return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
    }


    private List<SecurityContext> securityContexts(){
        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
    }




    private List<SecurityReference> sf(){
        AuthorizationScope scope = new AuthorizationScope("global","accessEverything");
        return  Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[]{scope}));
    }

    @Bean
    public Docket api(){


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .securityContexts(securityContexts())
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo() {
        return new ApiInfo("Exam Portal Spring Boot Angular","Developed By Anu-rag Sharma","1.0","Terms And Service",new Contact("Anu-rag","localhost:8081/","anurag.sharma@zehntech.com"),"License of Apis","Api License URl",Collections.emptyList());

    }



}


