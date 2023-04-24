package com.example.providerapi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan

public class ProviderController {

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> readAccount(@PathVariable String id)
    {

        Account account = new Account();


        return new ResponseEntity<Account>(account,HttpStatus.OK);
    }


    @PostMapping("/account")
    public void fullBody(@RequestBody String fullBody)
    {
        System.out.println(fullBody);
    }


}
