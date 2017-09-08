package com.example.demo.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "coutries-service-client", url = "http://country.io")
public interface WeatherServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/names.json")
    String getCountries();
}
