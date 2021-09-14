package com.farmingassistant.backend.hay;

import com.farmingassistant.backend.ApiWeatherToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HayService {

    @Autowired
    private ApiWeatherToken weatherToken;

    public List<com.example.demo.hay.Hay> getHay(String insee) throws IOException, InterruptedException, ParseException {
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://api.meteo-concept.com/api/forecast/daily?token="+weatherToken.getWeatherApiToken()+"&insee=" + insee)).header("accept", "application/json").build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body());
            List weather = (List) jsonObject.get("forecast");
            List<com.example.demo.hay.Hay> listOfHay = new ArrayList<com.example.demo.hay.Hay>();
            HashMap<Integer, Integer> listOfTemperature = new HashMap<>();
            HashMap<Integer, Integer> listOfProbarain = new HashMap<>();
            for (int i = 0; i < weather.size(); i++) {
                JSONObject dayWeather = (JSONObject) weather.get(i);
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(String.valueOf(dayWeather));
                Long probarains = (Long) jsonObject1.get("probarain");
                Long days = (Long) jsonObject1.get("day");
                Long temperatures = (Long) jsonObject1.get("tmin");
                Integer day = Math.toIntExact(days);
                Integer probarain = Math.toIntExact(probarains);
                Integer temperature = Math.toIntExact(temperatures);
                listOfTemperature.put(day, temperature);
                listOfProbarain.put(day, probarain);
            }
            for (int i = 0; i < weather.size(); i++) {
                JSONObject dayWeather = (JSONObject) weather.get(i);
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(String.valueOf(dayWeather));
                Long day = (Long) jsonObject1.get("day");
                int day1 = day.intValue();
                boolean temperatureDay0Condition;
                int temperatureDay0Data;
                boolean temperatureDay1Condition;
                int temperatureDay1Data;
                boolean temperatureDay2Condition;
                int temperatureDay2Data;
                boolean dryDay0Condition;
                int dryDay0Data;
                boolean dryDay1Condition;
                int dryDay1Data;
                boolean dryDay2Condition;
                int dryDay2Data;

                if (day1 < 12) {
                    dryDay2Data = listOfProbarain.get(i + 2);
                    temperatureDay2Data = listOfTemperature.get(i + 2);
                    if (dryDay2Data < 25) {
                        dryDay2Condition = true;
                    } else {
                        dryDay2Condition = false;
                    }
                    if (temperatureDay2Data > 15) {
                        temperatureDay2Condition = true;
                    } else {
                        temperatureDay2Condition = false;
                    }
                } else {
                    temperatureDay2Condition = false;
                    temperatureDay2Data = 0;
                    dryDay2Condition = false;
                    dryDay2Data = 0;
                }

                if (day1 < 13) {
                    dryDay1Data = listOfProbarain.get(i + 1);
                    temperatureDay1Data = listOfTemperature.get(i + 1);
                    if (dryDay1Data < 25) {
                        dryDay1Condition = true;
                    } else {
                        dryDay1Condition = false;
                    }
                    if (temperatureDay1Data > 15) {
                        temperatureDay1Condition = true;
                    } else {
                        temperatureDay1Condition = false;
                    }
                } else {
                    temperatureDay1Condition = false;
                    temperatureDay1Data = 0;
                    dryDay1Condition = false;
                    dryDay1Data = 0;
                }

                dryDay0Data = listOfProbarain.get(i);
                temperatureDay0Data = listOfTemperature.get(i);
                if (dryDay0Data < 25) {
                    dryDay0Condition = true;
                } else {
                    dryDay0Condition = false;
                }
                if (temperatureDay0Data > 15) {
                    temperatureDay0Condition = true;
                } else {
                    temperatureDay0Condition = false;
                }
                com.example.demo.hay.Hay hay = new com.example.demo.hay.Hay(day1, temperatureDay0Condition, temperatureDay0Data, dryDay0Condition, dryDay0Data, temperatureDay1Condition, temperatureDay1Data, dryDay1Condition, dryDay1Data, temperatureDay2Condition, temperatureDay2Data, dryDay2Condition, dryDay2Data);
                listOfHay.add(hay);
            }
            return listOfHay;
        }
        catch (Exception e) {
            List listOfException = new ArrayList();
            listOfException.add("Api Weather is failed to use");
            return listOfException;
        }
    }
}
