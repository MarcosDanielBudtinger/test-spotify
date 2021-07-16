package com.test.spotify;

import com.test.spotify.service.WeatherService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class WeatherServiceTest {
    
    @TestConfiguration
    static class WeatherServiceTestConfiguration {
        @Bean
        public WeatherService bookingService() {
            return new WeatherService();
        }
    }

    @Autowired
    WeatherService weatherService;

    @Test
    public void weatherServiceTestReturnParty() {
        double temp = 30.15;
        String response = weatherService.returnTracks(temp);
        Assertions.assertEquals(response, "party");
    }


    @Test
    public void weatherServiceTestReturnPop() {
        double temp = 15.00;
        String response = weatherService.returnTracks(temp);
        Assertions.assertEquals(response, "pop");
    }


    @Test
    public void weatherServiceTestReturnRock() {
        double temp = 14.00;
        String response = weatherService.returnTracks(temp);
        Assertions.assertEquals(response, "rock");
    }

    @Test
    public void weatherServiceTestReturnDefaultClassical() {
        double temp = 9.00;
        String response = weatherService.returnTracks(temp);
        Assertions.assertEquals(response, "classical");
    }


}
