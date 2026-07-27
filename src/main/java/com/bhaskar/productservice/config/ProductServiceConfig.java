package com.bhaskar.productservice.config;

import com.bhaskar.productservice.constants.PropertyConstants;
import com.bhaskar.productservice.services.ProductService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProductServiceConfig {

    @Bean
    @Primary
    public ProductService productService(AppProperties appProperties, BeanFactory beanFactory) {
        String flowBeanName = appProperties.getProperty(PropertyConstants.PRODUCT_SERVICE_FLOW);
        return beanFactory.getBean(flowBeanName, ProductService.class);
    }
}
