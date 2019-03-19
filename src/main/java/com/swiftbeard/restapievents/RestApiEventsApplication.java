package com.swiftbeard.restapievents;

import com.swiftbeard.restapievents.domain.Rate;
import com.swiftbeard.restapievents.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RestApiEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiEventsApplication.class, args);
    }

    @Bean
    public CommandLineRunner data(CurrencyService service) {
        return (args) -> {
            service.saveRate(new Rate("EUR",0.88857F,new Date()));
            service.saveRate(new Rate("JPY",102.17F,new Date()));
            service.saveRate(new Rate("MXN",19.232F,new Date()));
            service.saveRate(new Rate("GBP",0.75705F,new Date()));
        };
    }

}
