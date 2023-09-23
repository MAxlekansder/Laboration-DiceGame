package com.AlexanderHasslund.demo;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

//behöver ses över - hur den bäst körs
public class Tarningar {


    //se över om det ska läggas in som en parameter
    public int antalTarningar() {
        int antalTarningar = Input.intInput();
        return antalTarningar;
    }

    //se över om det ska läggas in som en parameter
    public int sidorTarningar() {
        int antalSidor = Input.intInput();
        return antalSidor;
    }

    public void tarningarArray2(int antalTarningar, int antalSidor, int antalSpelare) {

        Random tarningRand = new Random();

        int totalSumma = 0;

        int tarningRandSida = 0;
        int[][] antalTarningArray2 = new int[antalSpelare][antalTarningar];
        //System.out.print("Hur många tärningar per spelare?: ");
        for (int i = 0; i < antalTarningArray2.length; i++) {
            for (int j = 0; j < antalTarningar; j++) {
                antalTarningArray2[i][j] = tarningRand.nextInt(antalSidor) + 1;
                //totalSumma = totalSumma + antalTarningArray2[i][j];
            }
            System.out.println("Loop");
            System.out.println(totalSumma);
            System.out.println(Arrays.deepToString(antalTarningArray2));

            System.out.println(" ----> " + Arrays.toString(antalTarningArray2[i]) + IntStream.of(antalTarningArray2[i]).sum());
            //här kanske är ett bra tillfälle att få in spelare?


            //och även kunna göra summeringen per array för att sen tilldela det till totalSumma...!!!
        }
        //vi kan nog flytta in den här i stora for-loopen
        for (int i = 0; i < antalSpelare; i++) {
            for (int j = 0; j < antalTarningar; j++) {
                totalSumma = totalSumma + antalTarningArray2[i][j];

                Spelare nySpelare = new Spelare(totalSumma);

            }
            System.out.println(totalSumma);
            //totalSumma = 0;
        }
    }

    public void tarningarArray(int antalTarningar, int antalSidor) {

        //lite för klurlig lösning just nu
        Random tarningRand = new Random();
        //den kör om frågan igen...
        int tarningRandSida = 0;
        int[] antalTarningArray = new int[antalTarningar];
        //System.out.print("Hur många tärningar per spelare?: ");
        for (int i = 0; i < antalTarningArray.length; i++) {
            antalTarningArray[i] = tarningRand.nextInt(antalSidor) + 1;
        }

        //for (int i = 0; i < myTest.length; i++) {
        //  for (int j = 0 ; j <myTest[i].length; j++) {
        //System.out.println(tarningRandSida);

        //System.out.println(Arrays.toString(antalTarningArray));
        /*
        try {
            //antalTarningArray = new int[Input.intInput()];
            System.out.println(Arrays.toString(antalTarningArray) + " " + antalTarningArray.length);


        } catch (java.util.InputMismatchException e) {
            System.out.println("Du behöver skriver in ett heltal för antalet tärningar! <-- i metod tarning rad 28");
        }


         */
        //return antalTarningArray;
    }

    //stoppa in ett värde från input direkt, istället för att återuppa det hela tiden?
    //kommer basera maxtaket med random beroende på sidorna


    // släng in hur många sidor tärningarna ska ha?

    //lista ut hur jag ska lägga till värdet och hur jag slår ut det i arrayen...
    //tror jag har en plan här <-- kika lite merpå den

    /*
      if (antalTarningArray2[i][antalTarningar] == 0) {
                System.out.println("första klar!");
                System.out.println(Arrays.deepToString(antalTarningArray2));
            } else {
                System.out.println("Nästa på tur!");
                System.out.println(Arrays.deepToString(antalTarningArray2));
            }
     */
    public void kastaTarning() {

        //mata in random här istället?

    }

}






