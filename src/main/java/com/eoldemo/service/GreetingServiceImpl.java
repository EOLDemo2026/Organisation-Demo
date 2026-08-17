package com.eoldemo.service;

import com.eoldemo.config.ConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImpl implements GreetingService {

    private final ConfigUtil configUtil;

    public GreetingServiceImpl(ConfigUtil configUtil) {
        this.configUtil = configUtil;
    }

    @Override
    public String greet(String name) {
        String prefix = configUtil.getGreetingPrefix();
        String who = StringUtils.isBlank(name) ? "World" : name;
        return prefix + who + "!";
    }
}
