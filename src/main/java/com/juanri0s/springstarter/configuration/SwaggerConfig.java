package com.juanri0s.springstarter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket userApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiUser())
        .select()
        .paths(PathSelectors.regex("/api.*"))
        .build();
  }

  private ApiInfo apiUser() {
    return new ApiInfoBuilder()
        .title("User REST api")
        .description("REST api for User Crud using JPA and JDBC")
        .termsOfServiceUrl("https://creativecommons.org/licenses/by/4.0/")
        .license("GNU General Public License v3.0")
        .contact(new Contact("Example", "www.example.com", "example@email.com"))
        .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html")
        .version("1.0")
        .build();
  }
}
