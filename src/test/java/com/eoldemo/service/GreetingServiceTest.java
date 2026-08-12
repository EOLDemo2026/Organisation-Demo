package com.eoldemo.service;

import com.eoldemo.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreetingServiceTest {
    @Test
    public void testGreet() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingService svc = ctx.getBean(GreetingService.class);
        Assert.assertEquals("Hello, Alice!", svc.greet("Alice"));
        ctx.close();
    }
}
