package com.AlexanderHasslund.demo;

import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.*;

public class Input {

    public static String stringInput() {
        String stringInput = null;

        //just nu är den här try catchen helt värdelös
        // ta bort do här...
            //FIXME fixa så att det här inte strular...
            try {
                Scanner stringScan = new Scanner(System.in);
                stringInput = stringScan.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Du behöver skriva in ett strängvärde för att komma vidare");
            }
        return stringInput;

    }

    public static int intInput() {
        int intInput = 0;

        //sätt in en while för att inte bryta den när vi kör OM problem uppstår
        try {
            Scanner intScan = new Scanner(System.in);
            intInput = intScan.nextInt();

        } catch (java.util.InputMismatchException e) {
            System.out.println("Du behöver skriva in ett heltal för att komma vidare");
        }
        return intInput;
    }
}
