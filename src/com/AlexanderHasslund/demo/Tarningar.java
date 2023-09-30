package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


//behöver ses över - hur den bäst körs
public class Tarningar {

    public static int antalTarningar;
    public static int antalSidor;
    public static int turer;

    public void setAntalTarningar(int antalTarningar) {
        this.antalTarningar = antalTarningar;
    }

    public int getAntalTarningar() {
        return antalTarningar;
    }

    public void setSidorTarningar(int antalSidor) {
        this.antalSidor = antalSidor;
    }

    public int getSidorTarningar() {
        return antalSidor;
    }

    public void tarningarArray2(int antalTarningar, int antalSidor, int antalSpelare) {
        Random tarningRand = new Random();
        Scoreboard scoreboard = new Scoreboard();
        int[][] antalTarningArray2 = new int[antalSpelare][antalTarningar];

        //System.out.print("Hur många tärningar per spelare?: ");
        for (int i = 0; i < antalTarningArray2.length; i++) {
            System.out.println("\nTryck enter för att rulla: " + Spelare.nySpelareArr.get(i).namn + "!");
            String enter = Input.stringInput();
            if (enter.isEmpty() || enter.isBlank() || !enter.isEmpty()) {
                for (int j = 0; j < antalTarningar; j++) {
                    antalTarningArray2[i][j] = tarningRand.nextInt(antalSidor) + 1;
                }

                System.out.println(Spelare.nySpelareArr.get(i).namn
                        + " rullade " + Arrays.toString(antalTarningArray2[i])
                        + " och har totalt " + IntStream.of(antalTarningArray2[i]).sum() + " poäng");

                Spelare.nySpelareArr.get(i).totalSumma = Spelare.nySpelareArr.get(i).totalSumma + IntStream.of(antalTarningArray2[i]).sum();
            }
        }
        turer++;
    }
}










