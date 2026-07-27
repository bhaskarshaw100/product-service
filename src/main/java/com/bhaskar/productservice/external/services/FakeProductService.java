package com.bhaskar.productservice.external.services;

import com.bhaskar.productservice.config.AppProperties;
import com.bhaskar.productservice.constants.PropertyConstants;
import com.bhaskar.productservice.external.dtos.FakeProductRequest;
import com.bhaskar.productservice.external.dtos.FakeProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService {

    private final RestTemplate restTemplate;
    private final AppProperties appProperties;

    public FakeProductService(RestTemplate restTemplate, AppProperties appProperties) {
        this.restTemplate = restTemplate;
        this.appProperties = appProperties;
    }

    public List<FakeProductResponse> getAllProducts() {
        String url = appProperties.getProperty(PropertyConstants.FAKE_STORE_BASE_URL);
        return restTemplate.getForObject(url, List.class);
    }

    public FakeProductResponse createFakeProduct(FakeProductRequest fakeProductRequest) {
        String url = appProperties.getProperty(PropertyConstants.FAKE_STORE_BASE_URL);
        System.out.println("Creating fake product: " + fakeProductRequest);
        FakeProductResponse fakeProductResponse = restTemplate.postForObject(url, fakeProductRequest, FakeProductResponse.class);
        System.out.println("Created fake product: " + fakeProductResponse);
        return fakeProductResponse;
    }
}
