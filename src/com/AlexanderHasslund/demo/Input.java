package com.AlexanderHasslund.demo;
import java.util.Scanner;
import java.util.*;

public class Input {

    public static String stringInput() {
        String stringInput = null;
        boolean stringCheck = true;

        while (stringCheck) {
            try {
                Scanner stringScan = new Scanner(System.in);
                stringInput = stringScan.nextLine();
                stringCheck = false;

            } catch (InputMismatchException e) {
                System.out.println("Du behöver skriva in ett strängvärde för att komma vidare");
            }
        }

        return stringInput;

    }

    public static int intInput() {
        int intInput = 0;
        boolean intCheck = true;

        while (intCheck) {
            try {
                Scanner intScan = new Scanner(System.in);
                intInput = intScan.nextInt();
                intCheck = false;


            } catch (InputMismatchException e) {
                System.out.println("Du behöver skriva in ett heltal för att komma vidare");
            }

        }
        return intInput;
    }
}
