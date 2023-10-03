package com.AlexanderHasslund.demo.Blazer;

import com.AlexanderHasslund.demo.HanteraVinnare;
import com.AlexanderHasslund.demo.SpelarLogik;
import com.AlexanderHasslund.demo.Spelare;
import com.AlexanderHasslund.demo.Tarningar;
import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import com.AlexanderHasslund.demo.interaktionsStruktur.Menyer;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.SpelarInfoMeddelanden;

public class BlazerTarning {

    //hanterar alla övriga metoder och kör alla metoder beroende på ett par kriterier
    public void antalOmgångar() throws InterruptedException {
        Scoreboard scoreboard = new Scoreboard();
        HanteraVinnare hanteraVinnare = new HanteraVinnare();
        SpelarInfoMeddelanden spelarInfoMeddelanden = new SpelarInfoMeddelanden();

        if (Spelare.nySpelareArr.isEmpty()) {
            System.out.println("Ingen vann!");
        } else {

            do {
                for (int i = 0; i < 7; i++) {
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
                        SpelarLogik.isPlayingBlazer = false;
                        break;
                    }

                    if (Spelare.nySpelareArr.size() == 1) {
                        spelarInfoMeddelanden.omEndastEnVinnare();
                        SpelarLogik.isPlayingBlazer = false;
                        break;
                    }
                    if (i == 6 && Spelare.nySpelareArr.size() > 1) {
                        hanteraVinnare.mainHanteraVinnare();
                        SpelarLogik.isPlayingBlazer = false;
                        break;
                    }

                    if (Spelare.nySpelareArr.get(0).totalSumma >= 21) {
                        spelarInfoMeddelanden.omEndastEnVinnare();
                        SpelarLogik.isPlayingBlazer = false;
                        break;
                    }


                }
            } while (SpelarLogik.isPlayingBlazer);
        }
    }

    //om spelaren är över 10 poäng får den en tagg
    public void blazerRondaRegler() {
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (Spelare.nySpelareArr.get(i).totalSumma > 10) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 1;
            }
        }
    }

    //om spelaren inte klarade sig tar bort vi hen från spelet
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

    //här kastar vi tärningen med statiska värden direkt i metoden -> 1 täning, 6 sidor.
    public void kastaBlazerTarning() {
        Tarningar tarning = new Tarningar();
        tarning.tarningarArray(1, 6, Spelare.nySpelareArr.size());
    }
}

