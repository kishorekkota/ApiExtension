package com.example.pactconsumerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProviderService {
    private final RestTemplate restTemplate;

    @Autowired
    public ProviderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getAllProducts() {

        return restTemplate.exchange("/products",
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<List<Product>>(){}).getBody();
    }
    private HttpEntity<String> getRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, generateAuthToken());
        return new HttpEntity<>(headers);
    }
    private String generateAuthToken() {
        return "Bearer " +  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(new Date());
    }
    public Product getProduct(String id) {
        return restTemplate.getForObject("/products/{id}", Product.class, id);
    }
}
