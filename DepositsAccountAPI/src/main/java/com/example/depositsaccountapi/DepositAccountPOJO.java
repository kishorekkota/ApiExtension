package com.example.depositsaccountapi;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class DepositAccountPOJO {


    private String accountId;

    private boolean active;

    private AccountStatus status;

    private Double balance;

    private DepositsAccountEXT deposits_api_ext;

}
