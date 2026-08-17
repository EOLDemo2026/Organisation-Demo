package com.eoldemo.config;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.springframework.stereotype.Component;

@Component
public class ConfigUtil {
    private final PropertiesConfiguration config;

    public ConfigUtil() {
        Configurations configs = new Configurations();
        PropertiesConfiguration c;
        try {
            c = configs.properties("application.properties");
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
