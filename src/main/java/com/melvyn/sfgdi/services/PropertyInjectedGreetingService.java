package com.melvyn.sfgdi.services;

import org.springframework.stereotype.Service;

/**
 * Created by Melvyn on 10/Aug/2020
 */
@Service
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting () {
        return "Hello World - Property";
    }
}
