package com.eoldemo;

import com.eoldemo.config.AppConfig;
import com.eoldemo.security.AuthService;
import com.eoldemo.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        AuthService auth = ctx.getBean(AuthService.class);
        // demo credentials: user / password (in-memory)
        boolean logged = auth.login("user", "password");
        if (!logged) {
            System.err.println("Authentication failed - exiting");
            ctx.close();
            return;
        }

        GreetingService svc = ctx.getBean(GreetingService.class);
        String name = (args != null && args.length > 0) ? args[0] : "World";
        System.out.println(svc.greet(name));

        auth.logout();
        ctx.close();
    }
}
