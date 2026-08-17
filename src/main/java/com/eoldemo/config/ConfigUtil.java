package com.eoldemo.config;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ConfigUtil {
    private final PropertiesConfiguration config;

    public ConfigUtil() {
        PropertiesConfiguration c;
        try {
            c = new PropertiesConfiguration("application.properties");
        } catch (Exception e) {
            c = new PropertiesConfiguration();
            c.setProperty("greeting.prefix", "Hello, ");
        }
        this.config = c;
    }

    public String getGreetingPrefix() {
        return config.getString("greeting.prefix", "Hello, ");
    }
}
