package com.AlexanderHasslund.demo;

import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.*;

public class Input {

    public static String stringInput() {
        String stringInput = null;
        boolean stringCheck = true;
        //just nu är den här try catchen helt värdelös
        // ta bort do här...
        //FIXME fixa så att det här inte strular...
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

        //sätt in en while för att inte bryta den när vi kör OM problem uppstår
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
