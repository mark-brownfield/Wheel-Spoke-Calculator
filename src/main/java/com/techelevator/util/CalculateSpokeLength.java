package com.techelevator.util;

import com.techelevator.wheel.Hoop;
import com.techelevator.wheel.Hub;
import com.techelevator.wheel.Spokes;

import java.text.DecimalFormat;

import static java.lang.Math.sqrt;

public class CalculateSpokeLength {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double calculateSpokeLengthNonDifferential(Hoop hoop, Hub hub, Spokes spokes){
        double spokeLength = 0;
        double r = hoop.getEffectiveRimDiameter() / 2;
        double h = hub.getHubFlangePCD();
        double f = hub.getFlangeOffSetNonDrive() - hub.getFlangeOffSetDrive();
        double n = hoop.getSpokeHoleCount();
        double x = spokes.getCrossPattern();

        double y = (4 * Math.PI * x) / h;

        double tempMath = (r * r) + (h * h) - 2 * r * h * Math.cos(y);
        spokeLength = sqrt(tempMath);
        return Double.parseDouble(df.format(spokeLength));
    }

    /*public static double calculateSpokeLengthDifferential(Hoop hoop, Hub hub, Spokes spokes){
        double spokeLength = 0;
        double r = hoop.getEffectiveRimDiameter() / 2;
        double h = hub.getHubFlangePCD();
        double fn = hub.getFlangeOffSetNonDrive();
        double fd = hub.getFlangeOffSetDrive();
        double n = hoop.getSpokeHoleCount();
        double x = spokes.getCrossPattern();


    }*/

}
