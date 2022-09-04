package com.techelevator.util;

import com.techelevator.util.CalculateSpokeLength;
import com.techelevator.util.Logger;
import com.techelevator.wheel.Hoop;
import com.techelevator.wheel.Hub;
import com.techelevator.wheel.Spokes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WheelBuildCalculator {

    public static void run() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("");
        System.out.println("*********************************************************************");
        System.out.println("Hello! Welcome to the Wheel Builder Calculator");
        System.out.println("I hope you have your supplies ready, because its time to measure!");
        System.out.println("");
        System.out.println("First, let's take some hoop/rim measurements.");
        System.out.println("-----------------------------------------------");

        System.out.println("Select the size wheels are you building: ");
        System.out.println("1.) 26 inch");
        System.out.println("2.) 27.5 inch");
        System.out.println("3.) 650b");
        System.out.println("4.) 700c");
        System.out.println("5.) 29 inch");

        Map<Integer, Double> validRimSizesMap = new HashMap<>();
        validRimSizesMap.put(1, 26.0);
        validRimSizesMap.put(2, 27.5);
        validRimSizesMap.put(3, 650.0);
        validRimSizesMap.put(4, 700.0);
        validRimSizesMap.put(5, 29.0);

        String initialRimInput = userInput.nextLine();
        int rimSelection = Integer.parseInt(initialRimInput);
        double givenRimSize = validRimSizesMap.get(rimSelection);

        Hoop.actualRimSize(validRimSizesMap, rimSelection);

        System.out.println("How many spokes?");
        int givenSpokeHoleCount = Integer.parseInt(userInput.nextLine());

        System.out.println("What is the rim's Effective Rim Diameter? (in millimeters)");
        double givenERD = Double.parseDouble(userInput.nextLine());

        Hoop newHoop = new Hoop(givenRimSize, givenSpokeHoleCount, givenERD);

        System.out.println("Your rim's actual diameter is: " +
                newHoop.rimSizeToMillimeters(newHoop.getRimSize()) + "mm");
        System.out.println("Number of spoke holes: " + newHoop.getSpokeHoleCount());
        System.out.println("Effective Rim Diameter: " + newHoop.getEffectiveRimDiameter() + "mm");

        System.out.println("");
        System.out.println("Now, let's take some hub measurements.");
        System.out.println("-----------------------------------------------");
        System.out.println("");
        System.out.println("What is your hub's Pitch Circle Diameter " +
                "(PCD, the distance between opposite spoke holes on one flange) in millimeters?");
        double givenPCD = Double.parseDouble(userInput.nextLine());

        System.out.println("How many total spoke holes does your hub have? (This should match your hoop)");
        int givenSpokeCountHub = Integer.parseInt(userInput.nextLine());
        if (givenSpokeCountHub != givenSpokeHoleCount){
            System.out.println("Your hub needs to match your hoop! Get a different a hub and come back.");
            System.out.println("How many total spoke holes does your hub have? (This should match your hoop)");
        }

        System.out.println("Does your hub need J-Bend spokes? Y or N ");
        String initialBendInput = userInput.nextLine();
        String givenIsJBend = initialBendInput.trim().toUpperCase();
        boolean givenIsJBendBoolean;
        if (givenIsJBend == "Y"){
            givenIsJBendBoolean = true;
        } else {
            givenIsJBendBoolean = false;
        }

        System.out.println("Are you using disc brakes? Y or N ");
        String initialDiscInput = userInput.nextLine();
        String givenIsDisc = initialDiscInput.trim().toUpperCase();
        boolean givenIsDiscBoolean;
        double givenFlangeOffsetDS = 0;
        double givenFlangeOffsetNonDS = 0;
            if (givenIsDisc == "Y") {
                givenIsDiscBoolean = true;
                System.out.println("What is the drive-side flange offset? ");
                givenFlangeOffsetDS = Double.parseDouble(userInput.nextLine());
                System.out.println("What is the non-drive-side flange offset? ");
            } else {
                givenIsDiscBoolean = false;
                System.out.println("What is the drive-side flange offset? ");
                givenFlangeOffsetDS = Double.parseDouble(userInput.nextLine());
                System.out.println("What is the non-drive-side flange offset? (Should be the same as drive-side)");
                givenFlangeOffsetNonDS = Double.parseDouble(userInput.nextLine());
            }

        Hub newHub = new Hub(givenPCD, givenSpokeCountHub,
                givenIsDiscBoolean, givenFlangeOffsetDS, givenFlangeOffsetNonDS, givenIsJBendBoolean);

        /*System.out.println("Lastly, what is the cross pattern you'll use on your spokes? (3) ");
        String inputCrossPattern = userInput.nextLine();
        int givenCrossPattern = Integer.parseInt(inputCrossPattern);

        Spokes newSpokes = new Spokes(givenCrossPattern);*/

        Spokes newSpokes = new Spokes(3);

        Logger logger = new Logger("wheel-build-history.txt");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm:ss a");
        logger.write(now.format(formatter) + " " + "Calculated Spoke length: " +
                CalculateSpokeLength.calculateSpokeLengthNonDifferential(newHoop, newHub, newSpokes));

        System.out.println("");
        System.out.println("*********************************************************");
        System.out.println("Your required spoke length is: " +
                CalculateSpokeLength.calculateSpokeLengthNonDifferential(newHoop, newHub, newSpokes) + "mm");
        System.out.println("");
        System.out.println("*********************************************************");

    }
}
