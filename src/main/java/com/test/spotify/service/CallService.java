package com.test.spotify.service;

import java.time.LocalDateTime;

import com.test.spotify.model.Call;

import org.springframework.stereotype.Service;

@Service
public class CallService {
    
    public Call createNewCall(String cityName){
        Call call = new Call();
        call.setDate(LocalDateTime.now());
        call.setCityName(cityName);
        return call;
    }
}
