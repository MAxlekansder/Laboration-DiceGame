package com.AlexanderHasslund.demo;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        //instansiera allt här
        HanteraVinnare hanteraVinnare = new HanteraVinnare();
        SpelarData spelarData = new SpelarData();
        Scoreboard scoreboard = new Scoreboard();
        StartUpGame startUpGame = new StartUpGame();
        TarningsLogik tarningsLogik = new TarningsLogik();

        boolean spelareReggad = false;
        int turer = 0;

        startUpGame.startUpGame();
        spelarData.sparaAntalSpelare();
        spelarData.sparaAntalRundor();
        spelarData.checkAntalSpelare();


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

                            tarningsLogik.checkaOchKasta();
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

                        break;
                    case 4:
                        scoreboard.scoreboard();
                        break;
                    case 5:
                        System.out.println("Tack för att du spelade!");
                        startUpGame.isPlaying = false;
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
