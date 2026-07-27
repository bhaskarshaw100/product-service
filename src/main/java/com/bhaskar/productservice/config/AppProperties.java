package com.bhaskar.productservice.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    private final Environment environment;

    public AppProperties(Environment environment) {
        this.environment = environment;
    }

    public String getProperty(String key) {
        return environment.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return environment.getProperty(key, defaultValue);
    }

    public Boolean getBooleanProperty(String key) {
        return environment.getProperty(key, Boolean.class);
    }
}
