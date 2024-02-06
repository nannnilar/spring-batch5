package com.example.graphqlclientdemo.service;

import com.example.graphqlclientdemo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service

public class CountryService {
    private final GraphQlClient graphQlClient;

    public CountryService(){
        WebClient client = WebClient.builder().baseUrl("https://countries.trevorblades.com").build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }

    public Mono<List<Country>> getCountries(){
        String document = """
                query{
                    countries{
                      name
                      emoji
                      currency
                      code
                      capital
                    }
                }
                """;
      Mono<List<Country>> countries =  graphQlClient.document(document)
              .retrieve("countries").toEntityList(Country.class);
      return countries;
    }

}















