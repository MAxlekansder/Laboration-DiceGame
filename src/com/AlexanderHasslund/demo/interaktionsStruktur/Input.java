package com.AlexanderHasslund.demo.interaktionsStruktur;
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
               // String catchBlankInput = intScan.nextLine();
                if (intInput > 0) {
                    //intScan.nextLine(); verkar inte funga som tänkt <- ta bort överflödet.
                    intCheck = false;
                } else {
                    System.out.println("Heltalet behöver större än noll! och får inte vara tom");
                }
            } catch (InputMismatchException e) {
                System.out.println("Du behöver skriva in ett heltal för att komma vidare");
            }

        }
        return intInput;
    }
}
