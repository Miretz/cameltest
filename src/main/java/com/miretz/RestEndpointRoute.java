package com.miretz;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestEndpointRoute extends RouteBuilder {

    public static final int JETTY_PORT = 9090;

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("jetty").bindingMode(RestBindingMode.json)
                .dataFormatProperty("prettyPrint", "true")
                .port(JETTY_PORT);

        rest("/say")
                .get("/hello").to("direct:hello")
                .get("/bye").consumes("application/json").to("direct:bye")
                .post("/bye").to("mock:update");

        from("direct:hello")
                .transform().constant("Hello World");
        from("direct:bye")
                .transform().constant("Bye World");

    }
}
