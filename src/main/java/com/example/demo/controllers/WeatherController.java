package com.example.demo.controllers;


import com.example.demo.feignClients.WeatherServiceClient;
import com.example.demo.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherServiceClient weatherServiceClient;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity getWeather() {

        List<Weather> weatherList = new ArrayList<>();

        Weather weather = new Weather();
        weather.setTemp(74.2);
        weather.setRelativeHumid(74.2);
        weather.setWindSpd(2);
        weather.setWindDir(215);

        weatherList.add(weather);

        weatherList.add(new Weather(new Double(12), new Double(7)
                , new Integer(5), new Integer(101)));

        return new ResponseEntity<>(weatherList, HttpStatus.OK);
    }

    @RequestMapping(path = "/countries", method = RequestMethod.GET)
    public String getCountries() {
        return weatherServiceClient.getCountries();
    }
}
