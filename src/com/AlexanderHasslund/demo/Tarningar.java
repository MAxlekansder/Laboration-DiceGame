package com.AlexanderHasslund.demo;

import java.util.Arrays;
import java.util.Random;

//behöver ses över - hur den bäst körs
public class Tarningar {


    //se över om det ska läggas in som en parameter
    public int tarningarAntal() {
        int antalTarningar = Input.intInput();
        return antalTarningar;
    }

    //se över om det ska läggas in som en parameter
    public int sidorTarningar() {
        int antalSidor = Input.intInput();
        return antalSidor;
    }


    public int[] tarningarArray() {

        //lite för klurlig lösning just nu
        Random tarningRand = new Random();
        int[] antalTarningArray = new int[0];
        //System.out.print("Hur många tärningar per spelare?: ");
        try {
            antalTarningArray = new int[Input.intInput()];
            System.out.println(Arrays.toString(antalTarningArray) + " " + antalTarningArray.length);


        } catch (java.util.InputMismatchException e) {
            System.out.println("Du behöver skriver in ett heltal för antalet tärningar! <-- i metod tarning rad 28");
        }

        return antalTarningArray;
    }

    //stoppa in ett värde från input direkt, istället för att återuppa det hela tiden?
    //kommer basera maxtaket med random beroende på sidorna


    // släng in hur många sidor tärningarna ska ha?

    public static void kastaTarning() {


    }

}
