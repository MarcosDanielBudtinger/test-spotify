package com.test.spotify.weathermapintegration;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    
    public String returnTracks(double temp){
        String track = "classical";
        if(temp > 30){
            track = "party";
        }
        if(temp >= 15 && temp <= 30){
            track = "pop";
        }
        if(temp >= 10 && temp <= 14){
            track = "rock";
        }
        return track;
    }
}
