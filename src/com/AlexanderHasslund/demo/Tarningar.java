package com.AlexanderHasslund.demo;
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

    public int totalSummaMetod(int antalTarningar, int antalSidor, int totalSumma) {
        Tarningar tarning = new Tarningar();


        return totalSumma;
    }

    public int tarningarArray2(int antalTarningar, int antalSidor, int antalSpelare) {

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
            //System.out.println(Arrays.deepToString(antalTarningArray2));
            System.out.println(Main.nySpelareArr.get(i).namn + " ----> " + Arrays.toString(antalTarningArray2[i]) + IntStream.of(antalTarningArray2[i]).sum());



            //här kanske är ett bra tillfälle att få in spelare?
            //och även kunna göra summeringen per array för att sen tilldela det till totalSumma...!!!
        }
        //vi kan nog flytta in den här i stora for-loopen
        for (int i = 0; i < antalSpelare; i++) {
            for (int j = 0; j < antalTarningar; j++) {
                totalSumma = totalSumma + antalTarningArray2[i][j];
                //System.out.println(totalSumma);

                Main.nySpelareArr.get(i).totalSumma = IntStream.of(antalTarningArray2[i]).sum();
            }
            System.out.println(totalSumma);
            //totalSumma = 0;
        }
        return totalSumma;
    }

    public void kastaTarning() {

        //mata in random här istället?
    }
}






