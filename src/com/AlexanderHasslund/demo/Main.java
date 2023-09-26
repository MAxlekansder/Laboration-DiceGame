package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Menu;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        //instansiera allt här
        Scoreboard scoreboard = new Scoreboard();
        Menu myMenu = new Menu();
        Tarningar tarning = new Tarningar();
        boolean isPlaying = true;
        boolean spelareReggad = false;
        int sparaAntalSpelare = 0;
        int turer = 0;


        StartUpGame.startUpGame();
        System.out.println("Hur många spelare? ");
        sparaAntalSpelare = Input.intInput();


        System.out.println("Hur många rundor? ");
        int antalRundor = Input.intInput();
        Spelare nySpelare = new Spelare("", 0, 0, 0);

        /* TODO PLACEHOLDER FÖR SPELARE*/


        do {


            try {
                //kallar på menyvalen i klass Menu
                myMenu.menu();
                int användarVal = Input.intInput();


                switch (användarVal) {
                    // flytta ut case 1 utanför och regga spelare först?
                    case 1:

                        System.out.println("Ange namn och ålder för vardera spelare: ");

                        for (int i = 0; i < sparaAntalSpelare; i++) {

                            System.out.print("Namn Spelare " + (i + 1) + ": ");
                            String namn = Input.stringInput();
                            System.out.print("Ålder Spelare " + (i + 1) + ": ");
                            int alder = Input.intInput();
                            int uniktSpelarId = i + 1;

                            nySpelare = new Spelare(namn, alder, uniktSpelarId, 0);
                            Spelare.nySpelareArr.add(nySpelare);

                        }

                        //för att slippa att vi loopar rubriken
                        System.out.println(String.format("\n%-20s", "\033[1;33m --- SPELARE ---"));

                        //fungerar bra men formeringen kanske ska flyttas? Ser fluffigt ut
                        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                            int uniktSpelarId = i + 1;

                            //desto mer jag fyller ut, desto mer känner jag att det behövs flyttas ut till: interaktionsStruktur
                            System.out.print("\033[1;33mSPELARE " + uniktSpelarId + "\u001B[0m ");
                            System.out.println(Spelare.nySpelareArr.get(i).toString());
                        }

                        spelareReggad = true;
                        break;

                    case 2:
                        //sätt in ett sätt som stoppar folk från att spela fler gånger om det inte var med till en början?
                        //free mode?
                        System.out.println("Hur många sidor ska tärningen ha?");
                        int sparadSida = tarning.sidorTarningar();

                        System.out.println("Hur många tärningar ska kastas per spelare?");
                        int sparatAntal = tarning.antalTarningar();
                        // tarning.tarningarArray(sparatAntal, sparadSida);
                        tarning.tarningarArray2(sparatAntal, sparadSida, sparaAntalSpelare);

                        scoreboard.sortSpelarLista();
                        //scoreboard.scoreboard();

                        boolean isPlayerOneTrue = false;            //bygg in en safe boolean check på spelaren
                        turer++;

                        if (turer == antalRundor && Spelare.nySpelareArr.size() > 1) {

                            //här vill jag få in logiken av flera vinnare från isPlayerReomveTrue
                            //sen borde vi flytta ut allt det här för att hålla det rent i main...
                            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                                if (Spelare.nySpelareArr.get(0).totalSumma == Spelare.nySpelareArr.get(i).totalSumma) {
                                    Spelare.nySpelareArr.get(i).isPlayerRemoveTrue = true;
                                }
                            }
                            System.out.println(Spelare.nySpelareArr);
                            if (isPlayerOneTrue) {
                                scoreboard.scoreboard();
                                System.out.println("\n \u001B[1;32m -----VINNAREN ÄR---- \u001B[0m ");
                                System.out.println("\033[1;33m SPELARE: \u001B[0m " + Spelare.nySpelareArr.get(0).namn + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
                            } else {
                            System.out.println("Vi har flera vinnare!");
                                System.out.println(Spelare.nySpelareArr);
                                scoreboard.scoreboard();
                            }



                            //fyll ut här med att ta genom det sista innan spelet slutas!
                            //presentera en vinnare här med så att vi vet att någon vann!

                            //få in en jämförelse mellan vinnaren och de undre! Så om 3st rullar 1 1 1, då har ju alla vunnit, eller ingen vunnit!
                            /*
                            scoreboard.scoreboard();

                            System.out.println("\n \u001B[33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE: \u001B[0m " + Spelare.nySpelareArr.get(0).namn
                                    + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
                                    */

                            isPlaying = false;
                        } else {
                            System.out.println("Du rullade bra!");
                            System.out.println("Tack för att du spelade!");
                            isPlaying = false;
                        }
                        //scoreboard.scoreboard();

                        break;
                    case 3:
                        System.out.println("sortera");
                        scoreboard.sortSpelarLista();
                        //rulla här eller i case 2?
                        //kombinera spelare och tärningar
                        break;
                    case 4:

                        scoreboard.scoreboard();

                        //nySpelareArr.remove(1);

                        break;
                    case 5:
                        System.out.println("Tack för att du spelade!");
                        isPlaying = false;
                        break;
                    default:
                        System.out.println("Håll dig inom angivna valen");
                }
            } catch (MissingFormatWidthException e) {
                System.out.println("Använd dig av heltal för att navigera menyn!");
            }

        }
        while (isPlaying);
    }

}

//flytta ut till Hantera vinnare?
                            /*
                            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                                if (Spelare.nySpelareArr.get(0).totalSumma != Spelare.nySpelareArr.get(i).totalSumma) {
                                    isPlayerOneTrue = true;
                                 //   Spelare.nySpelareArr.get(i).isPlayerRemoveTrue = true;
                                    System.out.println(Spelare.nySpelareArr);
                                    break; // break för att inte kolla alla svar... men tänker att det kanske inte behövs?
                                }
                            }   */