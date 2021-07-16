package com.test.spotify.event.listener;

import com.test.spotify.event.CallMadeEvent;
import com.test.spotify.repository.CallRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CallMadeListener implements ApplicationListener<CallMadeEvent>{

    @Autowired
    private CallRepository callRepository;

    @Override
    public void onApplicationEvent(CallMadeEvent event) {
        callRepository.save(event.getCall());
    }
    
}
