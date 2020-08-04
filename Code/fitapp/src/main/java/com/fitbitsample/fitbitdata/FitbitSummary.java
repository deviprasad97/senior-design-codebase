package com.fitbitsample.fitbitdata;

public class FitbitSummary {
    private Integer activeScore, activityCalories, caloriesBMR, caloriesOut, fairlyActiveMinutes, lightlyActiveMinutes, marginalCalories, sedentaryMinutes, steps, veryActiveMinutes;

    public FitbitSummary(Integer activeScore, Integer activityCalories, Integer caloriesBMR, Integer caloriesOut, Integer fairlyActiveMinutes, Integer lightlyActiveMinutes, Integer marginalCalories, Integer sedentaryMinutes, Integer steps, Integer veryActiveMinutes) {
        this.activeScore = activeScore;
        this.activityCalories = activityCalories;
        this.caloriesBMR = caloriesBMR;
        this.caloriesOut = caloriesOut;
        this.fairlyActiveMinutes = fairlyActiveMinutes;
        this.lightlyActiveMinutes = lightlyActiveMinutes;
        this.marginalCalories = marginalCalories;
        this.sedentaryMinutes = sedentaryMinutes;
        this.steps = steps;
        this.veryActiveMinutes = veryActiveMinutes;
    }

    public Integer getActiveScore() {
        return activeScore;
    }

    public void setActiveScore(Integer activeScore) {
        this.activeScore = activeScore;
    }

    public Integer getActivityCalories() {
        return activityCalories;
    }

    public void setActivityCalories(Integer activityCalories) {
        this.activityCalories = activityCalories;
    }

    public  Integer getCaloriesBMR() {
        return caloriesBMR;
    }

    public void setCaloriesBMR(Integer caloriesBMR) {
        this.caloriesBMR = caloriesBMR;
    }

    public Integer getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(Integer caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    public Integer getFairlyActiveMinutes() {
        return fairlyActiveMinutes;
    }

    public void setFairlyActiveMinutes(Integer fairlyActiveMinutes) {
        this.fairlyActiveMinutes = fairlyActiveMinutes;
    }

    public Integer getLightlyActiveMinutes() {
        return lightlyActiveMinutes;
    }

    public void setLightlyActiveMinutes(Integer lightlyActiveMinutes) {
        this.lightlyActiveMinutes = lightlyActiveMinutes;
    }

    public Integer getMarginalCalories() {
        return marginalCalories;
    }

    public void setMarginalCalories(Integer marginalCalories) {
        this.marginalCalories = marginalCalories;
    }

    public Integer getSedentaryMinutes() {
        return sedentaryMinutes;
    }

    public void setSedentaryMinutes(Integer sedentaryMinutes) {
        this.sedentaryMinutes = sedentaryMinutes;
    }

    public  Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getVeryActiveMinutes() {
        return veryActiveMinutes;
    }

    public void setVeryActiveMinutes(Integer veryActiveMinutes) {
        this.veryActiveMinutes = veryActiveMinutes;
    }
}
