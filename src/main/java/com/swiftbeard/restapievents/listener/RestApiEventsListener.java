package com.swiftbeard.restapievents.listener;

import com.swiftbeard.restapievents.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class RestApiEventsListener implements ApplicationListener<ApplicationEvent> {

    private static final String LATEST = "/currency/latest";


    @Autowired
    private CounterService counterService;

    @Log(printParamsValues=true)
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ServletRequestHandledEvent){
            if(((ServletRequestHandledEvent)event).getRequestUrl().equals(LATEST)){
                counterService.increment("url.currency.lastest.hits");
            }
        }
    }
}
