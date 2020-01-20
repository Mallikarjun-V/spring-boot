package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

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
    public Docket postsApi() {
        
        /*
         * return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
         * .paths(postPaths()).build();
         */
        
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(("com.learn.controller"))).build();
    }
    
    private Predicate<String> postPaths() {
        return Predicates.or(PathSelectors.regex("/api/posts.*"), PathSelectors.regex("/api/javainuse.*"));
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API").description("REST API reference for developers")
                .termsOfServiceUrl("http://test.co.in").contact("test@gmail.com").license("Test License")
                .licenseUrl("test@gmail.com").version("1.0").build();
    }
    
}
