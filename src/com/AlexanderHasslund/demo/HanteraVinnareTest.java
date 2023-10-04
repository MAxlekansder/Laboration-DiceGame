package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.SpelarInfoMeddelanden;
import com.AlexanderHasslund.demo.interaktionsStruktur.Input;

public class HanteraVinnareTest {
    int introCount;
    String fleraVinnareVal;

    public void setFleraVinnareVal() {
        fleraVinnareVal = Input.stringInput();
    }
    public String getFleraVinnareVal() {
        return fleraVinnareVal;
    }

    public void hanteraVinnare() throws InterruptedException {
        SpelarInfoMeddelanden SpelarInfoMeddelanden = new SpelarInfoMeddelanden();

        int antalVinnare = 0;
        boolean fleraVinnare = false;

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (Spelare.nySpelareArr.get(0).totalSumma == Spelare.nySpelareArr.get(i).totalSumma) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 1;
                antalVinnare = antalVinnare + Spelare.nySpelareArr.get(i).isPlayerKeepTrue;
            }
        }

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (antalVinnare > 1) {
                fleraVinnare = true;
                break;
            }
        }

        if (fleraVinnare && introCount > 0) {
            fleraVinnare2();

        }else if (fleraVinnare) {
            SpelarInfoMeddelanden.utslagsGame();
            System.out.println("Är alla vinnare [J] eller vill ni rulla igen [N]? J//N");
            setFleraVinnareVal();
            introCount++;
            fleraVinnare2();

        } else {
            System.out.println("\n\u001B[1;33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE:\u001B[0m " + Spelare.nySpelareArr.get(0).namn
                    + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
            SpelarLogik.isPlaying = false;
        }
    }


    public void fleraVinnare2() throws InterruptedException {
        Tarningar tarningar = new Tarningar();
        Scoreboard scoreboard = new Scoreboard();
        boolean testLoop = true;

        do {
            if (getFleraVinnareVal().toLowerCase().equals("j")) {
                System.out.println("Alla vann!");
                System.out.println("Tack för att ni spelade tärningsspelet!");
                SpelarLogik.isPlaying = false;
                break;

            } else if (getFleraVinnareVal().toLowerCase().equals("n") && Spelare.nySpelareArr.size() > 1) {

                Spelare.nySpelareArr.removeIf(n ->(n.isPlayerKeepTrue == 0));
                scoreboard.sortSpelarLista();

                System.out.println("Då kastar vi igen om: ");
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + "...");
                    Thread.sleep(1000);
                }

                if (Spelare.nySpelareArr.size() > 1) {
                    testLoop = true;
                    for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                        Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
                    }

                   // scoreboard.utslagsScoreboard();
                    resetSpelareSumma();
                    //scoreboard.utslagsScoreboard();
                    if (Spelare.nySpelareArr.size() > 1 && tarningar.getSidorTarningar() != 0) {
                        tarningar.tarningarArray(tarningar.getAntalTarningar(), tarningar.getSidorTarningar(), Spelare.nySpelareArr.size());
                    } else {
                        tarningar.tarningarArray(1, 6, Spelare.nySpelareArr.size());
                    }
                    scoreboard.utslagsScoreboard();
                    hanteraVinnare();

                } else { testLoop = false;
                    hanteraVinnare();
                }

            } else {
                System.out.println("Välj rätt input!");
                setFleraVinnareVal();
            }

        } while (testLoop);
    }

    public void resetSpelareSumma() {
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).totalSumma = 0;
        }
    }
}