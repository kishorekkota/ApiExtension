package com.example.apiextension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AccountService implements GenericService<AccountPOJO> {

    Log log = org.apache.commons.logging.LogFactory.getLog(AccountService.class);




    private final WebClient extClient = WebClient.builder().baseUrl("http://localhost:8082").build();



    @Override
    public AccountPOJO validation(AccountPOJO pojo) {

        log.info(" BASE AccountService validation ");



        pojo = this.extClient.post().uri("/validation").body(BodyInserters.fromValue(pojo)).retrieve().bodyToMono(AccountPOJO.class).block();

        return pojo;
    }

    @Override
    public AccountPOJO pre_processing(AccountPOJO pojo) {

        log.info(" BASE AccountService pre_processing ");


        pojo = this.extClient.post().uri("/pre_processing").body(BodyInserters.fromValue(pojo)).retrieve().bodyToMono(AccountPOJO.class).block();

        log.info(" BASE AccountService pre_processing ");

        return pojo;
    }

    @Override
    public AccountPOJO execute(AccountPOJO pojo) {
        log.info(" BASE AccountService validation ");
        return pojo;
    }

    @Override
    public AccountPOJO post_processing(AccountPOJO pojo) {
        System.out.println(" BASE AccountService post_processing ");
        pojo = this.extClient.post().uri("/post_processing").body(BodyInserters.fromValue(pojo)).retrieve().bodyToMono(AccountPOJO.class).block();
        return pojo;
    }

    @Override
    public AccountPOJO event_publishing(AccountPOJO pojo) {
        System.out.println(" BASE AccountService event_publishing ");

        return pojo;
    }
}
