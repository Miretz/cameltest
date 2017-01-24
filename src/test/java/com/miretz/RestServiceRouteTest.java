package com.miretz;

import com.miretz.fakeservice.FakeService;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RestServiceRoute.class, FakeService.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableAutoConfiguration
public class RestServiceRouteTest {

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:startRest")
    protected ProducerTemplate template;

    @Test
    public void testCallRestServices() throws Exception {

        String expectedBody = "Fake Service 2 got message from FakeService1";

        resultEndpoint.expectedBodiesReceived(expectedBody);

        template.sendBody(null);

        resultEndpoint.assertIsSatisfied();

    }

}