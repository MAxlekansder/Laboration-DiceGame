package com.AlexanderHasslund.demo;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.*;


public class Main {


    public static void main(String[] args) {
        //instansiera allt här
        Scoreboard scoreboard = new Scoreboard();
        StartUpGame startUpGame = new StartUpGame();
        Tarningar tarning = new Tarningar();
        boolean isPlaying = true;
        boolean spelareReggad = false;
        int sparaAntalSpelare = 0;
        int turer = 0;

        //getters and setters?
        startUpGame.startUpGame();
        System.out.println("Hur många spelare? ");
        sparaAntalSpelare = Input.intInput();


        System.out.println("Hur många rundor? ");
        int antalRundor = Input.intInput();
        Spelare nySpelare = new Spelare("", 0, 0, 0);

        /* TODO PLACEHOLDER FÖR SPELARE*/


        do {
            try {
                //kallar på menyvalen i klass Menu
                startUpGame.menu();
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
                        if (spelareReggad && sparaAntalSpelare >= 1) {
                            //sätt in ett sätt som stoppar folk från att spela fler gånger om det inte var med till en början?
                            //free mode?
                            tarning.sidorTarningar();
                            tarning.antalTarningar();


                            System.out.println("Hur många sidor ska tärningen ha?");
                            int sparadSida = tarning.returnSidorTarningar();

                            System.out.println("Hur många tärningar ska kastas per spelare?");
                            int sparatAntal = tarning.returnAntalTarningar();
                            // tarning.tarningarArray(sparatAntal, sparadSida);
                            tarning.tarningarArray2(sparatAntal, sparadSida, sparaAntalSpelare);

                            scoreboard.sortSpelarLista();
                            //scoreboard.scoreboard();


                            turer++;
                            if (turer == antalRundor && Spelare.nySpelareArr.size() > 1) {

                                HanteraVinnare hanteraVinnare = new HanteraVinnare();
                                hanteraVinnare.hanteraVinnare();
                                isPlaying = false;

                            } else {
                                System.out.println("Du rullade bra!");
                                System.out.println("Tack för att du spelade!");
                                isPlaying = false;
                            }
                            scoreboard.scoreboard();
                            break;

                        } else {
                            System.out.println("Registrera alla spelare först, innan ni kastar tärningar!");
                            break;
                        }
                    case 3:
                        //Släng in blazer här
                        System.out.println("sortera");
                        scoreboard.sortSpelarLista();
                        //rulla här eller i case 2?
                        //kombinera spelare och tärningar
                        break;
                    case 4:
                        scoreboard.scoreboard();
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
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while (isPlaying);
    }
}
