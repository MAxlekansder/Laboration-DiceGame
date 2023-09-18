package com.AlexanderHasslund.demo;

import java.util.Arrays;
import java.util.Random;

//behöver ses över - hur den bäst körs
public class Tarningar {

    static Random tarningRand = new Random();
    static int[] antalTarning = new int[0];

    public static int[] tarningar() {

        //System.out.print("Hur många tärningar per spelare?: ");
        try {
            antalTarning = new int[Input.intInput()];
            System.out.println(Arrays.toString(antalTarning) + " " + antalTarning.length);


        } catch (java.util.InputMismatchException e) {
            System.out.println("Du behöver skriver in ett heltal för antalet tärningar! <-- i metod tarning rad 28");
        }

        return antalTarning;
    }

    public int sidorTarningar() {

        int antalSidor = Input.intInput();

        return antalSidor;
    }

    // släng in hur många sidor tärningarna ska ha?

    public static void kastaTarning() {




    }

}
