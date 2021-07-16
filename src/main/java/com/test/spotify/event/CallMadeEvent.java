package com.test.spotify.event;

import com.test.spotify.model.Call;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class CallMadeEvent extends ApplicationEvent{
    
    @Getter
    private Call call;

    public CallMadeEvent(Object source, Call call) {
        super(source);
        this.call = call;
    }

}
