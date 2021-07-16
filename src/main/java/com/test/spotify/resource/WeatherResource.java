package com.test.spotify.resource;

import com.test.spotify.dto.WeatherResponse;
import com.test.spotify.event.CallMadeEvent;
import com.test.spotify.service.CallService;
import com.test.spotify.service.WeatherResponseService;
import com.test.spotify.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherResource {

    @Autowired
    private  WeatherResponseService weatherResponseService;

    @Autowired
    private WeatherService service;

    @Autowired
    private CallService callService;

    @Autowired
    ApplicationEventPublisher publisher;

    @RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
    public ResponseEntity<?> getWeather(@PathVariable String cityName) {
        WeatherResponse weatherResponse = weatherResponseService.getWeather(cityName);
        String response = service.returnTracks(weatherResponse.getMain().getTemp());
        publisher.publishEvent(new CallMadeEvent(this, callService.createNewCall(cityName)));
        return ResponseEntity.ok(response);
    }
}

