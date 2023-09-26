package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Menu;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.MissingFormatWidthException;

public class HanteraVinnare {

    public void hanteraVinnare() {
        {
            int antalVinnare = 0;
            boolean fleraVinnare = false;
            //här vill jag få in logiken av flera vinnare från isPlayerReomveTrue
            //sen borde vi flytta ut allt det här för att hålla det rent i main...
            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                if (Spelare.nySpelareArr.get(0).totalSumma == Spelare.nySpelareArr.get(i).totalSumma) {
                    Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 1;
                    System.out.println(Spelare.nySpelareArr.get(i).namn + " " + Spelare.nySpelareArr.get(i).isPlayerKeepTrue);
                    antalVinnare = antalVinnare + Spelare.nySpelareArr.get(i).isPlayerKeepTrue;
                }
            }

            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                if (antalVinnare > 1) {
                    fleraVinnare = true;
                }
            }

            if (fleraVinnare) {
                System.out.println("Vi har flera vinnare! ");
            } else {
                System.out.println("\n \u001B[1;33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE:\u001B[0m " + Spelare.nySpelareArr.get(0).namn
                        + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
            }
        }
    }
}



/*
if (isPlayerOneTrue) {
scoreboard.scoreboard();
System.out.println("\n \u001B[1;32m -----VINNAREN ÄR---- \u001B[0m ");
System.out.println("\033[1;33m SPELARE: \u001B[0m " + Spelare.nySpelareArr.get(0).namn + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
} else {
System.out.println("Vi har flera vinnare!");
System.out.println(Spelare.nySpelareArr);
scoreboard.scoreboard();


//fyll ut här med att ta genom det sista innan spelet slutas!
//presentera en vinnare här med så att vi vet att någon vann!

//få in en jämförelse mellan vinnaren och de undre! Så om 3st rullar 1 1 1, då har ju alla vunnit, eller ingen vunnit!

scoreboard.scoreboard();

System.out.println("\n \u001B[33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE: \u001B[0m " + Spelare.nySpelareArr.get(0).namn
+ " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");


isPlaying = false;
*/