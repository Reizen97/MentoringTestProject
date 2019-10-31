package com.mentoring.core;

import org.aeonbits.owner.Config;

public interface EnvCofig extends Config {

    @Key("google.url")
    String googleUrl();

    @Key("kieskeurig.url")
    String kieskeurigUrl();
}