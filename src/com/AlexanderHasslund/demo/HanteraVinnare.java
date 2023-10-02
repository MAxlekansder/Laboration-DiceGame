package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import com.AlexanderHasslund.demo.interaktionsStruktur.Menyer;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.SpelarInfoMeddelanden;

public class HanteraVinnare {
    public static String sparaAnvändarVal;
    int tur = 0;
    boolean isEnsamSpelare = true;

    public void mainHanteraVinnare() throws InterruptedException {
        SpelarInfoMeddelanden spelarInfoMeddelanden = new SpelarInfoMeddelanden();

        do {
            checkSpelareVidare();
            int getAntalVinnare = adderaSpelareCheck();
            if (getAntalVinnare > 1 && tur < 1) {
                spelarInfoMeddelanden.utslagsGame();
                omSpelareVal();
                användarInputYesorNo();
                tur++;
            } else {
                användarInputYesorNo();
                checkSpelareVidare();
                vinnareEllerRullaIgen();
            }
        } while (isEnsamSpelare);
    }

    public int adderaSpelareCheck() {
        int antalVinnare = 0;

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (Spelare.nySpelareArr.get(0).totalSumma == Spelare.nySpelareArr.get(i).totalSumma) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 1;

                antalVinnare = antalVinnare + Spelare.nySpelareArr.get(i).isPlayerKeepTrue;
            }
        }
        return antalVinnare;
    }

    public boolean checkSpelareVidare() {
        int getAntalVinnare = adderaSpelareCheck();

        boolean fleraVinnare = false;

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (getAntalVinnare > 1) {
                fleraVinnare = true;
                break;
            }
        }
        return fleraVinnare;
    }

    public void vinnareEllerRullaIgen() {
        boolean fleraVinnare = checkSpelareVidare();

        if (fleraVinnare) {
            kastaTarningMedSpelareReset();
        } else {
            System.out.println("\n\033[1;33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE:\u001B[0m " + Spelare.nySpelareArr.get(0).namn
                    + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!\n");
            Spelare.nySpelareArr.removeIf(n -> (n.isPlayerKeepTrue == 0));
            Menyer.isPlaying = false;
            isEnsamSpelare = false;
        }
    }

    public void omSpelareVal() {
        boolean catchStringInput = true;
        if (HanteraVinnare.sparaAnvändarVal == null) {
            do {

                System.out.println("\033[1;34mÄr alla vinnare [J] eller vill ni starta utslagsrundan [N]? \u001B[0mJ/N");
                HanteraVinnare.sparaAnvändarVal = Input.stringInput();

                if (HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("n") || HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("j")) {
                    catchStringInput = false;
                } else {
                    System.out.println("svara med 'J' eller 'N' för att komma vidare...");
                }
            } while (catchStringInput);
        }
        //return catchStringInput;
    }

    public void användarInputYesorNo() throws InterruptedException {
        Scoreboard scoreboard = new Scoreboard();
        int getAntalVinnare = adderaSpelareCheck();

        if (getAntalVinnare > 1) {

            if (HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("j")) {
                System.out.println("Alla vann!");

            } else if (HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("n") && Spelare.nySpelareArr.size() > 1) {

                System.out.println("OK - Då kastar vi igen om: rad 112 2 ");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + "...");
                    Thread.sleep(1000);
                }

                Spelare.nySpelareArr.removeIf(n -> (n.isPlayerKeepTrue == 0));
                scoreboard.sortSpelarLista();

                for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                    Spelare.nySpelareArr.get(i).totalSumma = 0;

                }
                for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                    Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
                }
            }
        }
    }

    public void kastaTarningMedSpelareReset() {
        Tarningar tarningar = new Tarningar();
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.utslagsScoreboard();

        if (Spelare.nySpelareArr.size() > 1) {
            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
            }
            tarningar.tarningarArray(tarningar.getAntalTarningar(), tarningar.getSidorTarningar(), Spelare.nySpelareArr.size());
        }
    }
}


