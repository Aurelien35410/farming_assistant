package com.farmingassistant.backend.phytosanitary;

public class Phytosanitary {

    private int day;
    private boolean windCondition;
    private int windData;
    private boolean temperatureCondition;
    private int maxtemperatureData;
    private int mintemperatureData;
    private boolean dryCondition;
    private int dryData;
    private boolean dampAfterCondition;

    public Phytosanitary(int day, boolean windCondition, int windData, boolean temperatureCondition, int maxtemperatureData, int mintemperatureData, boolean dryCondition, int dryData, boolean dampAfterCondition) {
        this.day = day;
        this.windCondition = windCondition;
        this.windData = windData;
        this.temperatureCondition = temperatureCondition;
        this.maxtemperatureData = maxtemperatureData;
        this.mintemperatureData = mintemperatureData;
        this.dryCondition = dryCondition;
        this.dryData = dryData;
        this.dampAfterCondition = dampAfterCondition;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isWindCondition() {
        return windCondition;
    }

    public void setWindCondition(boolean windCondition) {
        this.windCondition = windCondition;
    }

    public int getWindData() {
        return windData;
    }

    public void setWindData(int windData) {
        this.windData = windData;
    }

    public boolean isTemperatureCondition() {
        return temperatureCondition;
    }

    public void setTemperatureCondition(boolean temperatureCondition) {
        this.temperatureCondition = temperatureCondition;
    }

    public int getMaxtemperatureData() {
        return maxtemperatureData;
    }

    public void setMaxtemperatureData(int maxtemperatureData) {
        this.maxtemperatureData = maxtemperatureData;
    }

    public int getMintemperatureData() {
        return mintemperatureData;
    }

    public void setMintemperatureData(int mintemperatureData) {
        this.mintemperatureData = mintemperatureData;
    }

    public boolean isDryCondition() {
        return dryCondition;
    }

    public void setDryCondition(boolean dryCondition) {
        this.dryCondition = dryCondition;
    }

    public int getDryData() {
        return dryData;
    }

    public void setDryData(int dryData) {
        this.dryData = dryData;
    }

    public boolean isDampAfterCondition() {
        return dampAfterCondition;
    }

    public void setDampAfterCondition(boolean dampAfterCondition) {
        this.dampAfterCondition = dampAfterCondition;
    }

    @Override
    public String toString() {
        return "Phytosanitary{" +
                "day=" + day +
                ", windCondition=" + windCondition +
                ", windData=" + windData +
                ", temperatureCondition=" + temperatureCondition +
                ", maxtemperatureData=" + maxtemperatureData +
                ", mintemperatureData=" + mintemperatureData +
                ", dryCondition=" + dryCondition +
                ", dryData=" + dryData +
                ", dampAfterCondition=" + dampAfterCondition +
                '}';
    }
}


