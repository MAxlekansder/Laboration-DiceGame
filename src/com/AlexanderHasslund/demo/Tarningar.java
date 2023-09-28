package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


//behöver ses över - hur den bäst körs
public class Tarningar {
    public int antalTarningar;
    public int antalSidor;
    //se över om det ska läggas in som en parameter
    //setter
    public void antalTarningar() {
        System.out.println("Hur många tärningar ska kastas per spelare?");
        int antalTarningar = Input.intInput();
        this.antalTarningar = antalTarningar;
        //return antalTarningar;
    }

    //getter
    public int returnAntalTarningar() {
        return antalTarningar;
    }
    //se över om det ska läggas in som en parameter
    //setter
    public void sidorTarningar() {
        System.out.println("Hur många sidor ska tärningen ha?");
        int antalSidor = Input.intInput();
        this.antalSidor = antalSidor;
        //return antalSidor;
    }
    //getter
    public int returnSidorTarningar() {
        return antalSidor;
    }


    public void tarningarArray2(int antalTarningar, int antalSidor, int antalSpelare) {
        Random tarningRand = new Random();
        Scoreboard scoreboard = new Scoreboard();
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

            //för testsyfte ta bort sen

            //här kanske är ett bra tillfälle att få in spelare?
            //och även kunna göra summeringen per array för att sen tilldela det till totalSumma...!!!
        }
        scoreboard.scoreboard();
    }
}










