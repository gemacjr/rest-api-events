package com.swiftbeard.restapievents.service;

import com.swiftbeard.restapievents.domain.Rate;
import com.swiftbeard.restapievents.event.CurrencyEvent;
import com.swiftbeard.restapievents.repository.RateRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;

@Service
public class CurrencyService {
    private RateRepository repository;
    private ApplicationEventPublisher publisher;

    public CurrencyService(RateRepository repository,ApplicationEventPublisher publisher){
        this.repository = repository;
        this.publisher = publisher;
    }

    public void saveRates(Rate[] rates, Date date){
        Arrays.stream(rates).forEach(rate -> repository.save(new Rate(rate.getCode(),rate.getRate(),date)));
    }

    @Transactional
    public void saveRate(Rate rate){
        repository.save(new Rate(rate.getCode(),rate.getRate(),rate.getDate()));
        publisher.publishEvent(new CurrencyEvent(this,rate));
    }
}
