package com.miretz.fakeservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fake")
public class FakeService {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "FakeService1";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(@RequestBody String input) {
        return "Fake Service 2 got message from " + input;
    }

}