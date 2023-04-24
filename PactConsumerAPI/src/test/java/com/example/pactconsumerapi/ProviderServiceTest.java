package com.example.pactconsumerapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
public class ProviderServiceTest {

    private WireMockServer wireMockServer;
    private ProviderService providerService;

    @BeforeEach
    void setup()
    {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().dynamicPort());

        wireMockServer.start();

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(wireMockServer.baseUrl())
                .build();

        providerService = new ProviderService(restTemplate);


    }

    @AfterEach
    void tearDown()
    {
        wireMockServer.stop();
    }

    @Test
    void getAllProducts() {
        wireMockServer.stubFor(get(urlPathEqualTo("/products"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[" +
                                "{\"id\":\"9\",\"type\":\"CREDIT_CARD\",\"name\":\"GEM Visa\",\"version\":\"v2\"},"+
                                "{\"id\":\"10\",\"type\":\"CREDIT_CARD\",\"name\":\"28 Degrees\",\"version\":\"v1\"}"+
                                "]")));

        List<Product> expected = Arrays.asList(new Product("9", "CREDIT_CARD", "GEM Visa", "v2"),
                new Product("10", "CREDIT_CARD", "28 Degrees", "v1"));

        List<Product> products = providerService.getAllProducts();

        assertEquals(expected, products);
    }


    @Test
    void getProduct()
    {
        wireMockServer.stubFor(get(urlPathEqualTo("/products/9"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":\"9\",\"type\":\"CREDIT_CARD\",\"name\":\"GEM Visa\",\"version\":\"v2\"}")));

        Product expected = new Product("9", "CREDIT_CARD", "GEM Visa", "v2");

        assertEquals(expected, providerService.getProduct("9"));

    }
}
