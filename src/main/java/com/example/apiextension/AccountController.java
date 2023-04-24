package com.example.apiextension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class AccountController {

    @Autowired
    AccountService service;

//    @Autowired
//    AccountRepository repository;


    @GetMapping("/account/{id}")
    public ResponseEntity<AccountPOJO> readAccount(@PathVariable String id)
    {
        return new ResponseEntity<AccountPOJO>(HttpStatus.OK);
    }


    @PostMapping("/account")
    public ResponseEntity<AccountPOJO> createAccount(@RequestBody AccountPOJO _account)
    {

        //System.out.println(_account.getDeposits_api_ext().getJSONObject("test"));

        service.validation(_account);

        _account = service.pre_processing(_account);

        service.execute(_account);

        _account = service.post_processing(_account);

        service.event_publishing(_account);

        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println(mapper.writeValueAsString(_account));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(_account);
    }

}


