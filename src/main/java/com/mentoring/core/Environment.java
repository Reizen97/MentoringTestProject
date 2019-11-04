package com.mentoring.core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({"classpath:${env}.properties"})
public interface Environment extends Config {

    String url();
}