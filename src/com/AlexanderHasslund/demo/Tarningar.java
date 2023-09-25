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


    public void tarningarArray2(int antalTarningar, int antalSidor, int antalSpelare) {
        Random tarningRand = new Random();
        int sum1 = 0; //överflödig


        int[][] antalTarningArray2 = new int[antalSpelare][antalTarningar];
        //System.out.print("Hur många tärningar per spelare?: ");
        for (int i = 0; i < antalTarningArray2.length; i++) {
            for (int j = 0; j < antalTarningar; j++) {
                antalTarningArray2[i][j] = tarningRand.nextInt(antalSidor) + 1;
                //totalSumma = totalSumma + antalTarningArray2[i][j];
                //överflödig?
                sum1 = sum1 + antalTarningArray2[i][j];
            }
            //System.out.println(totalSumma);
            //System.out.println(Arrays.deepToString(antalTarningArray2));
            System.out.println(Spelare.nySpelareArr.get(i).namn + " ----> " + Arrays.toString(antalTarningArray2[i]) + IntStream.of(antalTarningArray2[i]).sum());

            Spelare.nySpelareArr.get(i).totalSumma = Spelare.nySpelareArr.get(i).totalSumma + IntStream.of(antalTarningArray2[i]).sum();
            System.out.println(Spelare.nySpelareArr.get(i).namn + " " + Spelare.nySpelareArr.get(i).totalSumma);

            //här kanske är ett bra tillfälle att få in spelare?
            //och även kunna göra summeringen per array för att sen tilldela det till totalSumma...!!!
        }
    }
}










