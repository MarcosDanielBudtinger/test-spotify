package com.test.spotify.service;


import com.test.spotify.dto.WeatherResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "weatherResponseService", url = "http://api.openweathermap.org/data/2.5/weather")
public interface WeatherResponseService {

    @RequestMapping("?q={cityName}&appid=6801fe9e74c3fd9d5a5b0ea6b668d7af&units=metric")
    WeatherResponse getWeather(@PathVariable("cityName") String cityName);
    
}
