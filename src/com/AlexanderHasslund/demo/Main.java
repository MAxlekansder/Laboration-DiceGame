package com.AlexanderHasslund.demo;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        //instansiera allt här
        HanteraVinnare hanteraVinnare = new HanteraVinnare();
        SpelarData spelarData = new SpelarData();
        Scoreboard scoreboard = new Scoreboard();
        StartUpGame startUpGame = new StartUpGame();
        Tarningar tarning = new Tarningar();
        boolean isPlaying = true;
        boolean spelareReggad = false;

        int sparatAntal = 0;
        int sparadSida = 0;
        int turer = 0;

        startUpGame.startUpGame();
        spelarData.sparaAntalSpelare();
        spelarData.sparaAntalRundor();


        do {
            try {
                startUpGame.menu();
                int användarVal = Input.intInput();

                switch (användarVal) {
                    case 1:

                        spelarData.reggaSpelare();
                        spelarData.reggadSpelare();


                        spelareReggad = true;
                        break;

                    case 2:
                        if (spelareReggad && spelarData.sparaAntalSpelare >= 1) {
                            if (sparadSida == 0) {
                                System.out.println("Hur många sidor ska tärningen ha?");
                                sparadSida = Input.intInput();
                                tarning.setSidorTarningar(sparadSida);
                            }

                            if (sparatAntal == 0) {
                                System.out.println("Hur många tärningar ska kastas per spelare?");
                                sparatAntal = Input.intInput();
                                tarning.setAntalTarningar(sparatAntal);
                            }

                            tarning.tarningarArray2(sparatAntal, sparadSida, spelarData.sparaAntalSpelare);
                            scoreboard.sortSpelarLista();

                            turer++;
                            if (turer == spelarData.antalRundor && spelarData.sparaAntalSpelare > 1) {

                                hanteraVinnare.hanteraVinnare();
                                startUpGame.endingGame();

                            } else if (turer == spelarData.antalRundor && spelarData.sparaAntalSpelare == 1){
                                System.out.println("Du rullade bra!");
                                System.out.println("Tack för att du spelade!");
                                //isPlaying = false;
                                startUpGame.endingGame();

                            } else {
                                scoreboard.scoreboard();
                                break;
                            }

                        } else {
                            System.out.println("Registrera alla spelare först, innan ni kastar tärningar!");
                        }
                        break;
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
                        System.out.println("Håll dig inom de angivna valen");
                }
            } catch (MissingFormatWidthException e) {
                System.out.println("Använd dig av heltal för att navigera menyn!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        while (startUpGame.isPlaying);
    }
}
   /*
                        System.out.println("Ange namn och ålder för vardera spelare: ");

                        for (int i = 0; i < sparaAntalSpelare; i++) {

                            System.out.print("Namn Spelare " + (i + 1) + ": ");
                            String namn = Input.stringInput();
                            System.out.print("Ålder Spelare " + (i + 1) + ": ");
                            int alder = Input.intInput();
                            int uniktSpelarId = i + 1;

                            nySpelare = new Spelare(namn, alder, uniktSpelarId, 0);
                            Spelare.nySpelareArr.add(nySpelare);
                        }*/

//för att slippa att vi loopar rubriken