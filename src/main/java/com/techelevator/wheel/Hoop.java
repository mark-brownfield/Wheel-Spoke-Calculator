package com.techelevator.wheel;

import java.util.Map;

public class Hoop {
    private double rimSize;
    private int spokeHoleCount;
    private double effectiveRimDiameter;

    public Hoop(double rimSize, int spokeHoleCount, double effectiveRimDiameter) {
        this.rimSize = rimSize;
        this.spokeHoleCount = spokeHoleCount;
        this.effectiveRimDiameter = effectiveRimDiameter;
    }

    public double getRimSize() {
        return rimSize;
    }

    public void setRimSize(double rimSize) {
        this.rimSize = rimSize;
    }

    public int getSpokeHoleCount() {
        return spokeHoleCount;
    }

    public void setSpokeHoleCount(int spokeHoleCount) {
        this.spokeHoleCount = spokeHoleCount;
    }

    public double getEffectiveRimDiameter() {
        return effectiveRimDiameter;
    }

    public void setEffectiveRimDiameter(int effectiveRimDiameter) {
        this.effectiveRimDiameter = effectiveRimDiameter;
    }

    public double rimSizeToMillimeters(double rimSize){
        double rimSizeActual = 0;
        if (rimSize == 26){
            rimSizeActual+= 559;
        } else if (rimSize == 27.5 || rimSize == 650){
            rimSizeActual+= 584;
        } else if (rimSize == 29 || rimSize == 700){
            rimSizeActual+= 622;
        }
        return rimSizeActual;
    }

    public static double actualRimSize(Map<Integer, Double> validRimSizesMap, int rimSelection) {
        for (Map.Entry<Integer, Double> rim : validRimSizesMap.entrySet()) {
            if (validRimSizesMap.containsKey(rimSelection)) {
                double givenRimSize = validRimSizesMap.get(rimSelection);
                return givenRimSize = validRimSizesMap.get(rimSelection);
            } else {
                double givenRimSize = validRimSizesMap.get(rimSelection);
                System.out.println("Not valid wheel size");
                System.exit(1);
            }
        }
        return 0.0;
    }
}
