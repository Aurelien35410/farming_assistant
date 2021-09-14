package com.farmingassistant.backend.phytosanitary;


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
public class PhytosanitaryService {

    @Autowired
    private ApiWeatherToken apiToken;

    public List<Phytosanitary> getPhytosanitary(String insee) throws IOException, InterruptedException, ParseException {
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://api.meteo-concept.com/api/forecast/daily?token=" + apiToken.getWeatherApiToken() + "&insee=" + insee)).header("accept", "application/json").build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body());
            List weather = (List) jsonObject.get("forecast");
            List<Phytosanitary> listOfPhytosanitary = new ArrayList<Phytosanitary>();
            HashMap<Integer, Boolean> listOfDamp = new HashMap<>();
            for (int i = 0; i < weather.size(); i++) {
                JSONObject dayWeather = (JSONObject) weather.get(i);
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(String.valueOf(dayWeather));
                Long probarain = (Long) jsonObject1.get("probarain");
                Long days = (Long) jsonObject1.get("day");
                Integer day = Math.toIntExact(days);
                listOfDamp.put(day, true);
                if (day < 12) {
                    listOfDamp.put(day, true);
                }
                if (day > 0) {
                    if (probarain < 25) {
                        listOfDamp.put(day - 1, false);
                    }
                }
                if (day > 1) {
                    if (probarain < 25) {
                        listOfDamp.put(day - 2, false);
                    }
                }
            }
            for (int i = 0; i < weather.size(); i++) {
                JSONObject dayWeather = (JSONObject) weather.get(i);
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(String.valueOf(dayWeather));
                Long day = (Long) jsonObject1.get("day");
                int day1 = day.intValue();
                Long windData = (Long) jsonObject1.get("wind10m");
                int windData1 = windData.intValue();
                Long maxTemperature = (Long) jsonObject1.get("tmax");
                int maxTemperature1 = maxTemperature.intValue();
                Long minTemperature = (Long) jsonObject1.get("tmin");
                int minTemperature1 = minTemperature.intValue();
                Long dryData = (Long) jsonObject1.get("probarain");
                int dryData1 = dryData.intValue();
                boolean windCondition = false;
                if (windData < 13) {
                    windCondition = true;
                }
                boolean temperatureCondition = false;
                if (maxTemperature > 15 && minTemperature < 25) {
                    temperatureCondition = true;
                }
                boolean dryCondition = false;
                if (dryData < 25) {
                    dryCondition = true;
                }
                boolean dampAfterCondition = false;
                dampAfterCondition = listOfDamp.get(i);
                Phytosanitary phytosanitary = new Phytosanitary(day1, windCondition, windData1, temperatureCondition, maxTemperature1, minTemperature1, dryCondition, dryData1, dampAfterCondition);
                listOfPhytosanitary.add(phytosanitary);
            }
            return listOfPhytosanitary;
        } catch (Exception e) {
            List listOfException = new ArrayList();
            listOfException.add("Api Weather is failed to use");
            return listOfException;
        }
    }
}
