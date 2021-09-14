package com.example.demo.hay;

public class Hay {

    private int day;
    private boolean temperatureDay0Condition;
    private int temperatureDay0Data;
    private boolean dryDay0Condition;
    private int dryDay0Data;
    private boolean temperatureDay1Condition;
    private int temperatureDay1Data;
    private boolean dryDay1Condition;
    private int dryDay1Data;
    private boolean temperatureDay2Condition;
    private int temperatureDay2Data;
    private boolean dryDay2Condition;
    private int dryDay2Data;

    public Hay(int day, boolean temperatureDay0Condition, int temperatureDay0Data, boolean dryDay0Condition, int dryDay0Data, boolean temperatureDay1Condition, int temperatureDay1Data, boolean dryDay1Condition, int dryDay1Data, boolean temperatureDay2Condition, int temperatureDay2Data, boolean dryDay2Condition, int dryDay2Data) {
        this.day = day;
        this.temperatureDay0Condition = temperatureDay0Condition;
        this.temperatureDay0Data = temperatureDay0Data;
        this.dryDay0Condition = dryDay0Condition;
        this.dryDay0Data = dryDay0Data;
        this.temperatureDay1Condition = temperatureDay1Condition;
        this.temperatureDay1Data = temperatureDay1Data;
        this.dryDay1Condition = dryDay1Condition;
        this.dryDay1Data = dryDay1Data;
        this.temperatureDay2Condition = temperatureDay2Condition;
        this.temperatureDay2Data = temperatureDay2Data;
        this.dryDay2Condition = dryDay2Condition;
        this.dryDay2Data = dryDay2Data;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isTemperatureDay0Condition() {
        return temperatureDay0Condition;
    }

    public void setTemperatureDay0Condition(boolean temperatureDay0Condition) {
        this.temperatureDay0Condition = temperatureDay0Condition;
    }

    public int getTemperatureDay0Data() {
        return temperatureDay0Data;
    }

    public void setTemperatureDay0Data(int temperatureDay0Data) {
        this.temperatureDay0Data = temperatureDay0Data;
    }

    public boolean isDryDay0Condition() {
        return dryDay0Condition;
    }

    public void setDryDay0Condition(boolean dryDay0Condition) {
        this.dryDay0Condition = dryDay0Condition;
    }

    public int getDryDay0Data() {
        return dryDay0Data;
    }

    public void setDryDay0Data(int dryDay0Data) {
        this.dryDay0Data = dryDay0Data;
    }

    public boolean isTemperatureDay1Condition() {
        return temperatureDay1Condition;
    }

    public void setTemperatureDay1Condition(boolean temperatureDay1Condition) {
        this.temperatureDay1Condition = temperatureDay1Condition;
    }

    public int getTemperatureDay1Data() {
        return temperatureDay1Data;
    }

    public void setTemperatureDay1Data(int temperatureDay1Data) {
        this.temperatureDay1Data = temperatureDay1Data;
    }

    public boolean isDryDay1Condition() {
        return dryDay1Condition;
    }

    public void setDryDay1Condition(boolean dryDay1Condition) {
        this.dryDay1Condition = dryDay1Condition;
    }

    public int getDryDay1Data() {
        return dryDay1Data;
    }

    public void setDryDay1Data(int dryDay1Data) {
        this.dryDay1Data = dryDay1Data;
    }

    public boolean isTemperatureDay2Condition() {
        return temperatureDay2Condition;
    }

    public void setTemperatureDay2Condition(boolean temperatureDay2Condition) {
        this.temperatureDay2Condition = temperatureDay2Condition;
    }

    public int getTemperatureDay2Data() {
        return temperatureDay2Data;
    }

    public void setTemperatureDay2Data(int temperatureDay2Data) {
        this.temperatureDay2Data = temperatureDay2Data;
    }

    public boolean isDryDay2Condition() {
        return dryDay2Condition;
    }

    public void setDryDay2Condition(boolean dryDay2Condition) {
        this.dryDay2Condition = dryDay2Condition;
    }

    public int getDryDay2Data() {
        return dryDay2Data;
    }

    public void setDryDay2Data(int dryDay2Data) {
        this.dryDay2Data = dryDay2Data;
    }

    @Override
    public String toString() {
        return "Hay{" +
                "day=" + day +
                ", temperatureDay0Condition=" + temperatureDay0Condition +
                ", temperatureDay0Data=" + temperatureDay0Data +
                ", dryDay0Condition=" + dryDay0Condition +
                ", dryDay0Data=" + dryDay0Data +
                ", temperatureDay1Condition=" + temperatureDay1Condition +
                ", temperatureDay1Data=" + temperatureDay1Data +
                ", dryDay1Condition=" + dryDay1Condition +
                ", dryDay1Data=" + dryDay1Data +
                ", temperatureDay2Condition=" + temperatureDay2Condition +
                ", temperatureDay2Data=" + temperatureDay2Data +
                ", dryDay2Condition=" + dryDay2Condition +
                ", dryDay2Data=" + dryDay2Data +
                '}';
    }
}
