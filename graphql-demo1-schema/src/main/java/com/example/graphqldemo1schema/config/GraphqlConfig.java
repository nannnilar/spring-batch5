package com.example.graphqldemo1schema.config;

import graphql.scalars.ExtendedScalars;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfig {
    private Logger logger = LoggerFactory.getLogger(GraphqlConfig.class);
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(){
        return wiringConfigurer -> wiringConfigurer
                    .scalar(ExtendedScalars.Date)
                    .scalar(ExtendedScalars.Url);
    }
    @Bean
    public GraphQlSourceBuilderCustomizer inspectionCustomizer(){
        return source -> source.inspectSchemaMappings(
                schemaReport -> logger.info(schemaReport.toString())
        );
    }

}
