package org.learn.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiListingBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.learn.java"))
                .paths(PathSelectors.regex("/api/rest.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
             return new ApiInfo("OUR REST APIs",
                    "THE REST API IS VERY GOOD",
                    "VERSION-1.0",
                    "https://www.newcombspring.com/terms-of-service",
                    new Contact("john Doe","www.bbc.com","best@gmail.com"),
                    "GNU PUBLIC V2.0",
                    "https://www.gnu.org/licenses/old-licenses/lgpl-2.0.html",
                    Collections.emptyList());
    }


}
/*
 Execution default-cli of goal io.github.swagger2markup:swagger2markup-maven-plugin:1.3.7:convertSwagger2markup failed:
 Plugin io.github.swagger2markup:swagger2markup-maven-plugin:1.3.7 or one of its dependencies could not be resolved:
 Failed to collect dependencies at io.github.swagger2markup:swagger2markup-maven-plugin:
 jar:1.3.7 -> io.github.swagger2markup:swagger2markup:jar:1.3.3 -> io.github.swagger2markup:
 markup-document-builder:jar:1.1.2 -> nl.jworks.markdown_to_asciidoc:markdown_to_asciidoc:jar:1.0:
 Failed to read artifact descriptor for nl.jworks.markdown_to_asciidoc:markdown_to_asciidoc:jar:1.0:
  Could not transfer artifact nl.jworks.markdown_to_asciidoc:markdown_to_asciidoc:
  pom:1.0 from/to maven-default-http-blocker (http://0.0.0.0/): Blocked mirror for repositories:
   [jcenter-snapshots (http://oss.jfrog.org/artifactory/oss-snapshot-local/, default, releases+snapshots),
   jcenter-releases (http://jcenter.bintray.com, default, releases)]
 */