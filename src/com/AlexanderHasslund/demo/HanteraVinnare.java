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
        Menyer menyer = new Menyer();

        do {
            checkSpelareVidare();
            int getAntalVinnare = adderaSpelareCheck();
            if (getAntalVinnare > 1 && tur < 1) {
                spelarInfoMeddelanden.utslagsGame();
                omSpelareVal();
                tur++;
            } else {
                användarInputYesorNo();
                checkSpelareVidare();
                if (HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("j")) {
                    Menyer.isPlaying = false;
                    break;

                }
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


    public void vinnareEllerRullaIgen() { // check om vi har flera vinnare / oavgjort
        boolean fleraVinnare = checkSpelareVidare();

        if (fleraVinnare) {
            kastaTarningUtslag();
        } else {
            System.out.println("\n\033[1;33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE:\u001B[0m " + Spelare.nySpelareArr.get(0).namn
                    + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!\n");
            Spelare.nySpelareArr.removeIf(n -> (n.isPlayerKeepTrue == 0));
            Menyer.isPlaying = false;
            isEnsamSpelare = false;
        }
    }


    public void omSpelareVal() { // frågar användaren om alla vann eller om de vill göra upp
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
    }


    public void användarInputYesorNo() throws InterruptedException { // tar värdet N / Y och statiskt lagrar det för att inte fråga anv igen
        int getAntalVinnare = adderaSpelareCheck();

        if (getAntalVinnare > 1) {

            if (HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("j")) {
                System.out.println("Alla vann!");

            } else if (HanteraVinnare.sparaAnvändarVal.toLowerCase().equals("n") && Spelare.nySpelareArr.size() > 1) {

                //scoreboard.utslagsScoreboard();
                System.out.println("Tryck enter när ni är redo att köra igen:");
                String enter = Input.stringInput();
                if (enter.isEmpty() || enter.isBlank() || !enter.isEmpty()) {

                    System.out.println("Då kastar vi igen om: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + "...");
                        Thread.sleep(1000);
                    }
                    taBortSpelareNollställ();
                }
            }
        }
    }


    public void taBortSpelareNollställ() { // tar bort spelare som inte klara sig vid oavgjort
        Scoreboard scoreboard = new Scoreboard();
        Spelare.nySpelareArr.removeIf(n -> (n.isPlayerKeepTrue == 0));
        scoreboard.sortSpelarLista();

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).totalSumma = 0;
        }
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
        }
    }


    public void kastaTarningUtslag() {  // nollställer check och kastar igen
        Tarningar tarningar = new Tarningar();
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.utslagsScoreboard();

        if (Spelare.nySpelareArr.size() > 1 && tarningar.getAntalTarningar() != 0) { // != 0 avgör spelmodet här...
            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
            }
            tarningar.tarningarArray(tarningar.getAntalTarningar(), tarningar.getSidorTarningar(), Spelare.nySpelareArr.size()); // för vanligt spel

        } else {
            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
            }
            tarningar.tarningarArray(1, 6, Spelare.nySpelareArr.size()); // för game mode: Blazer
        }
    }
}


