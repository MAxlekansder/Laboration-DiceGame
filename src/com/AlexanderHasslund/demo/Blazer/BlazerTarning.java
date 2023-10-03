package com.AlexanderHasslund.demo.Blazer;

import com.AlexanderHasslund.demo.HanteraVinnare;
import com.AlexanderHasslund.demo.Spelare;
import com.AlexanderHasslund.demo.Tarningar;
import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import com.AlexanderHasslund.demo.interaktionsStruktur.Menyer;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.SpelarInfoMeddelanden;

public class BlazerTarning {

    public void antalOmgångar() throws InterruptedException {
        Scoreboard scoreboard = new Scoreboard();
        HanteraVinnare hanteraVinnare = new HanteraVinnare();
        SpelarInfoMeddelanden spelarInfoMeddelanden = new SpelarInfoMeddelanden();
        boolean blazerLoop = true;

        if (Spelare.nySpelareArr.isEmpty()) {
            System.out.println("Ingen vann!");
        } else {

            do {
                for (int i = 0; i < 6; i++) {
                    System.out.println("\n\033[1;33m --- RONDA " + (i + 1) + " ---\u001B[0m");
                    System.out.println("Tryck enter för att fortsätta...");
                    String enter = Input.stringInput();

                    kastaBlazerTarning();

                    if (i == 3) {
                        blazerRondaRegler();
                        blazerSpelareVidare();
                        scoreboard.blazerScoreboard();
                    }

                    if (Spelare.nySpelareArr.isEmpty()) {
                        System.out.println("Ingen klarade sig! Alla förlorade...");
                        blazerLoop = false;
                        break;
                    }

                    if (Spelare.nySpelareArr.size() == 1) {
                        spelarInfoMeddelanden.omEndastEnVinnare();
                        blazerLoop = false;
                        break;
                    }
                    if (i == 5 && Spelare.nySpelareArr.size() > 1) {
                        hanteraVinnare.mainHanteraVinnare();
                        break;
                    }

                    if (Spelare.nySpelareArr.get(0).totalSumma >= 21) {
                        spelarInfoMeddelanden.omEndastEnVinnare();
                        blazerLoop = false;
                        break;
                    }


                }
            } while (blazerLoop);
        }
    }

    public void blazerRondaRegler() {
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (Spelare.nySpelareArr.get(i).totalSumma > 10) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 1;
            }
        }
    }

    public void blazerSpelareVidare() {
        Scoreboard scoreboard = new Scoreboard();

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (Spelare.nySpelareArr.get(i).isPlayerKeepTrue == 0) {
                System.out.println("\nSpelare " + Spelare.nySpelareArr.get(i).namn + " klarade sig inte! " + Spelare.nySpelareArr.get(i).totalSumma + " räcker inte till!\n Lycka till nästa gång!");
                //släng in en check här för att tilldella och radera -> kalla på metoden för checken? DRY...
            }
        }
        Spelare.nySpelareArr.removeIf(n -> (n.isPlayerKeepTrue == 0));
        scoreboard.sortSpelarLista();
    }

    public void kastaBlazerTarning() {
        Tarningar tarning = new Tarningar();
        tarning.tarningarArray(1, 6, Spelare.nySpelareArr.size());
    }
}

