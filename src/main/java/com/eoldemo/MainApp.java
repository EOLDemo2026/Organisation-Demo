package com.eoldemo;

import com.eoldemo.config.AppConfig;
import com.eoldemo.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingService svc = ctx.getBean(GreetingService.class);
        String name = (args != null && args.length > 0) ? args[0] : "World";
        System.out.println(svc.greet(name));
        ctx.close();
    }
}
