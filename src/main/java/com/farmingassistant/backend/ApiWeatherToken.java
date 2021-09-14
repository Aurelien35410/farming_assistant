package com.farmingassistant.backend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "token")
@Configuration("apiWeatherToken")
public class ApiWeatherToken {

    private String weatherApiToken;

    public String getWeatherApiToken() {
        return weatherApiToken;
    }

    public void setWeatherApiToken(String weatherApiToken) {
        this.weatherApiToken = weatherApiToken;
    }

}
