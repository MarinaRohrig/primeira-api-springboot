package br.com.futurodev.primeiraapi.springfox;

import io.swagger.annotations.Tag;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SpringFoxConfig {

@Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(metaData())
                .tags(new Tag("Usuários","Gerencia usuários"));
}

private ApiInfo metaData(){
    return new ApiInfoBuilder()
            .title("Spring Boot REST API")
            .description("Nossa primeira Spring Boot REST API")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .build();
}











}
