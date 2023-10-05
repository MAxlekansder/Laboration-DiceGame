package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.Blazer.BlazerMain;
import com.AlexanderHasslund.demo.interaktionsStruktur.*;

import java.util.*;


public class Main {



    public static void main(String[] args) throws InterruptedException {
        //instansiera allt här
        mainHanteraVinnare mainHanteraVinnare = new mainHanteraVinnare();
        SpelarInfoMeddelanden spelarInfoMeddelanden = new SpelarInfoMeddelanden();
        BlazerMain blazerMain = new BlazerMain();
        SpelarLogik spelarLogik = new SpelarLogik();
        Scoreboard scoreboard = new Scoreboard();
        Menyer menyer = new Menyer();
        TarningsLogik tarningsLogik = new TarningsLogik();
        boolean spelareReggad = false;
        int turer = 0;

        spelarInfoMeddelanden.startUpGame();
        spelarLogik.sparaAntalSpelare();
        spelarLogik.sparaAntalRundor();
        spelarLogik.checkAntalSpelare();


        do {
            try {
                menyer.menu();
                int användarVal = Input.intInput();

                switch (användarVal) {
                    case 1:
                        if (!spelareReggad) {
                            spelarLogik.reggaSpelare();
                            spelarLogik.reggadSpelare();
                            spelareReggad = true;

                        } else {
                            System.out.println("Alla spelare för denna runda är registrerade!");
                        }
                        break;
                    case 2:
                        if (spelareReggad && spelarLogik.sparaAntalSpelare >= 1) {
                            tarningsLogik.checkaOchKasta();
                            turer++;

                            if (turer == spelarLogik.antalRundor && spelarLogik.sparaAntalSpelare > 1) {
                               mainHanteraVinnare.hanteraVinnare();

                            } else if (turer == spelarLogik.antalRundor && spelarLogik.sparaAntalSpelare == 1) {
                                System.out.println("Du rullade bra!");
                                System.out.println("Tack för att du spelade!");
                                SpelarLogik.isPlaying = false;

                            } else {
                                scoreboard.scoreboard();
                                break;
                            }

                        } else {
                            System.out.println("Registrera alla spelare först, innan ni kastar tärningar!");
                        }
                        break;

                    case 3:
                        if (spelareReggad) {
                            blazerMain.blazerMain();
                            break;
                        } else {
                            System.out.println("Registrera alla spelare först, innan ni kastar tärningar!");
                        }
                        break;

                    case 4:
                        scoreboard.sortSpelarLista();
                        scoreboard.scoreboard();
                        break;

                    case 5:
                        System.out.println("Tack för att du spelade!");
                        SpelarLogik.isPlaying = false;
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
        while (SpelarLogik.isPlaying);
    }
}
