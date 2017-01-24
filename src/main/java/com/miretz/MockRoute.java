package com.miretz;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MockRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //filter only requests where the header contains foo: bar
        from("direct:startFoo").filter(header("foo").isEqualTo("bar")).to("mock:result");
    }
}
