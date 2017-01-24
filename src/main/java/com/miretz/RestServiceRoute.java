package com.miretz;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestServiceRoute extends RouteBuilder {

    public static final String FAKE_SERVICE = "http://localhost:8080/fake";

    @Override
    public void configure() throws Exception {
        from("direct:startRest").to(FAKE_SERVICE).to(FAKE_SERVICE).to("mock:result");
    }
}

