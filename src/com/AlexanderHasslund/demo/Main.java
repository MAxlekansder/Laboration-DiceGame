package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Menu;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.MissingFormatWidthException;

public class Main {
    public static void main(String[] args) {
        //instansiera allt här
        Menu myMenu = new Menu();
        Tarningar tarning = new Tarningar();
        boolean isPlaying = true;


        StartUpGame.startUpGame();

        System.out.println("Hur många spelare? ");
        int sparaAntalSpelare = Input.intInput();

        System.out.println("Hur många rundor? ");
        int antalRundor = Input.intInput();
        Spelare nySpelare = new Spelare("",0,0);

        /* TODO PLACEHOLDER FÖR SPELARE*/


        do {
            try{
                //kallar på menyvalen i klass Menu
                myMenu.menu();
                int användarVal = Input.intInput();
                //lite osäker på hur jag ska instansiera detta? Känns felaktigt...
                //Behålla totalSumma här eller utanför?
                //int totalSumma = 0;

                switch (användarVal) {
                    // flytta ut case 1 utanför och regga spelare först?
                    case 1:
                        //System.out.println("Ange namn och ålder på spelaren nedan!: ");
                        //Spelare nySpelare = new Spelare(Input.stringInput(), Input.intInput());
                        //jag vill nog ha vardera spelare bunden till antalet spelare?
                        //System.out.println(nySpelare.toString());
                        System.out.println("Ange namn och ålder för vardera spelare: ");
                        //det här stycket skapar spelare baserat på antalet som spelar --> skriver till klass Spelare
                        ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();
                        for (int i = 0; i < sparaAntalSpelare; i++) {

                            System.out.print("Namn Spelare " + (i + 1) + ": ");
                            String namn = Input.stringInput();
                            System.out.print("Ålder Spelare " + (i + 1) + ": ");
                            int alder = Input.intInput();
                            int uniktSpelarId = i + 1;

                            //nu lägger jag till totalSumma för att se hur den agerar...
                            //Spelare nySpelare = new Spelare(Input.stringInput(), Input.intInput());
                            nySpelare = new Spelare(namn, alder, uniktSpelarId);
                            nySpelareArr.add(nySpelare);
                        }

                            //för att slippa att vi loopar rubriken
                            System.out.println(String.format("\n%-20s", "\033[1;33m --- SPELARE ---"));

                            //fungerar bra men formeringen kanske ska flyttas? Ser fluffigt ut
                            for (int i = 0; i < nySpelareArr.size(); i ++) {
                                int uniktSpelarId = i + 1;

                                //desto mer jag fyller ut, desto mer känner jag att det behövs flyttas ut till: interaktionsStruktur
                                System.out.print("\033[1;33mSPELARE " + uniktSpelarId + "\u001B[0m ");
                                System.out.println(nySpelareArr.get(i).toString());
                            }


                        //lägg spelare här eller innan?
                        // släng in namnen här istället där uppe <--
                        break;

                    case 2:
                        System.out.println("Hur många sidor ska tärningen ha?");
                        int sparadSida = tarning.sidorTarningar();
                        System.out.println(sparadSida);

                        System.out.println("Hur många tärningar ska kastas per spelare?");
                        int sparatAntal = tarning.antalTarningar();
                        System.out.println(sparatAntal);

                        System.out.println("check");
                       // tarning.tarningarArray(sparatAntal, sparadSida);
                        tarning.tarningarArray2(sparatAntal, sparadSida, sparaAntalSpelare);

                        //System.out.println(Arrays.deepToString(tarning.tarnin);

                       // for (int i = 0; i < antalRundor; i++) {


                            //kasta x antal rundor och lagra dem...
                            //add funktion per array
                            //bundet till spelaren?
                            //hur lagrar jag det?

                            /* 3 personer kastar 2-sidig tärning 3 gånger m
                                ((rand tak 2) * 3) * 3
                                array?
                                SPELARE 1: [1,2,1] = skriv till sum 4
                                SPELARE 2: [2,1,2] = skriv till sum 5

                                efter det sortera - nu leder spelare2
                                SCOREBOARD
                                SPELARE 2: NAMNx total summa: 5
                                SPELREA 1: NAMNy total summa: 4

                              3 personer kastar 2-sidig tärning 3 gånger med 2 tärningar
                                (((rand tak 2) * 3) * 3) * 2
                                array?
                                SPELARE 1: [1,2,1] [2,2,2] = skriv till sum 10
                                SPELARE 2: [2,1,2] [1,2,1] = skriv till sum 9

                                efter det sortera - nu leder spelare2
                                SCOREBOARD
                                SPELARE 1: NAMNx total summa: 10
                                SPELREA 12: NAMNy total summa: 9


                             */

                        //välja antalet tärningar
                        //rulla här med? ta med if ()
                        break;
                    case 3:

                        //rulla här eller i case 2?
                        //kombinera spelare och tärningar
                        break;
                    case 4:

                        //återkalla scoreboard, vem leder? Ta med sort och räkna ihop
                        //kan vi skapa en scoreboard?
                        //sortera också - inkludera här -> fixa en bineary search
                        //FIXME efter en runda presentera resultatet!!! och sortera vem som leder!!

                        /* FIXME KÖR TVÅ GAME MODES!! SÄTT IN EN UTSLAGSTÄVLING! DÄR VI KÖR ARRAYLIST.POP
                        *   Kunna hela tiden veta vem som leder?
                        *   ta med runder så det går att sumera något */

                        break;
                    case 5:
                        System.out.println("Tack för att du spelade!");
                        isPlaying = false;
                        break;
                    default:
                        System.out.println("Håll dig inom angivna valen");
                }
            //se över om vi kan ta bort try catch...
            //fångar om användaren skriver in något annat - en sista failsafe, existerar redna en try i inten
            }catch(MissingFormatWidthException e)
            {
                System.out.println("Använd dig av heltal för att navigera menyn!"); }
        //do while körs så länge vi inte stänger ner det -> breakar case x:
        } while (isPlaying);



    }
}

