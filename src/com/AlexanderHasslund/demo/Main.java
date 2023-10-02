package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.Blazer.BlazerMain;
import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.Menyer;
import com.AlexanderHasslund.demo.interaktionsStruktur.SpelarInfoMeddelanden;

import java.util.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        //instansiera allt här

        HanteraVinnare hanteraVinnare = new HanteraVinnare();
        SpelarInfoMeddelanden spelarInfoMeddelanden = new SpelarInfoMeddelanden();
        BlazerMain blazerMain = new BlazerMain();
        SpelarData spelarData = new SpelarData();
        Scoreboard scoreboard = new Scoreboard();
        Menyer menyer = new Menyer();
        TarningsLogik tarningsLogik = new TarningsLogik();
        boolean spelareReggad = false;
        int turer = 0;

        spelarInfoMeddelanden.startUpGame();
        spelarData.sparaAntalSpelare();
        spelarData.sparaAntalRundor();
        spelarData.checkAntalSpelare();


        do {
            try {
                menyer.menu();
                int användarVal = Input.intInput();

                switch (användarVal) {
                    case 1:
                        if (!spelareReggad) {
                            spelarData.reggaSpelare();
                            spelarData.reggadSpelare();
                            spelareReggad = true;
                            break;
                        } else {
                            System.out.println("Alla spelare för denna runda är registrerade!");
                            break;
                        }

                    case 2:
                        if (spelareReggad && spelarData.sparaAntalSpelare >= 1) {
                            tarningsLogik.checkaOchKasta();
                            turer++;

                            if (turer == spelarData.antalRundor && spelarData.sparaAntalSpelare > 1) {

                                //hanteraVinnare.hanteraVinnare();
                                hanteraVinnare.mainHanteraVinnare();

                            } else if (turer == spelarData.antalRundor && spelarData.sparaAntalSpelare == 1) {
                                System.out.println("Du rullade bra!");
                                System.out.println("Tack för att du spelade!");
                                Menyer.isPlaying = false;

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
                        menyer.isPlaying = false;
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
        while (Menyer.isPlaying);
    }
}
