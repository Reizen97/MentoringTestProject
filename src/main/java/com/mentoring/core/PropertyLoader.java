package com.mentoring.core;

import org.aeonbits.owner.ConfigFactory;

public class PropertyLoader {

    private PropertyLoader() {
    }

    public static EnvCofig config = ConfigFactory.create(EnvCofig.class);
}

