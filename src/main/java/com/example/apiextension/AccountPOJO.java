package com.example.apiextension;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.Data;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.annotation.Id;

@Data
public class AccountPOJO extends BasePOJO {


    //@Id
    private String accountId;

    private boolean active;

    private AccountStatus status;

    private Double balance;

    private JsonNode deposits_api_ext;


    private String lendingStatus;


    @Override
    public String toString() {
        return "AccountPOJO{" +
                "accountId='" + accountId + '\'' +
                ", active=" + active +
                ", status=" + status +
                ", balance=" + balance +
                ", deposits_api_ext='" + deposits_api_ext+ '\'' +
                '}';
    }

}
