package com.farmingassistant.backend.fertilizer;

public class Fertilizer {

    private int day;
    private boolean windCondition;
    private int windData;
    private boolean dryCondition;
    private int dryData;
    private boolean dampAfterCondition;

    public Fertilizer(int day, boolean windCondition, int windData, boolean dryCondition, int dryData, boolean dampAfterCondition) {
        this.day = day;
        this.windCondition = windCondition;
        this.windData = windData;
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
        return "Fertilizer{" +
                "day=" + day +
                ", windCondition=" + windCondition +
                ", windData=" + windData +
                ", dryCondition=" + dryCondition +
                ", dryData=" + dryData +
                ", dampAfterCondition=" + dampAfterCondition +
                '}';
    }
}
