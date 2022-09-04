package com.techelevator.wheel;

public class Spokes {
    //private double spokeLength;
    private int crossPattern;

    public Spokes(int crossPattern) {
        this.crossPattern = crossPattern;
    }

    public int getCrossPattern() {
        return crossPattern;
    }

    public void setCrossPattern(int crossPattern) {
        this.crossPattern = crossPattern;
    }

}
