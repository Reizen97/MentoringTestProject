package com.mentoring.core;

import org.aeonbits.owner.Config;


@Config.Sources("clastpath:${env}.properties")
public interface Environment extends Config {

    String url();
}