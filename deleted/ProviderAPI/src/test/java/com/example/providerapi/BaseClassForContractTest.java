package com.example.providerapi;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = ProviderApiApplication.class)

public class BaseClassForContractTest {

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(ProviderController.class);
    }
}
