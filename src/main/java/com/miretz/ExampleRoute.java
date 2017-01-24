package com.miretz;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {

    @Autowired
    private HealthEndpoint health;

    @Override
    public void configure() {

        //log out the body of my bean
        from("timer:trigger")
                .transform().simple("ref:myBean")
                .to("log:out");

        //log out the health status
        from("timer:status")
                .bean(health, "invoke")
                .log("Health is ${body}");
    }

    @Bean
    String myBean() {
        return "I'm Spring bean!";
    }
}
