package com.example.providerapi;


import lombok.Data;

@Data
public class Account {


    private String accountNumber = "some_number";

    private String accountID = "some_acct_id";

    private Integer limitAmount = 1000;

    private String ssn = "ssn";

    private String email = "test@test.com";

}
