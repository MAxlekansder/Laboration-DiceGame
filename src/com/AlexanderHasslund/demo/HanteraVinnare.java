package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;
import org.w3c.dom.ls.LSOutput;

public class HanteraVinnare {

    public void hanteraVinnare() throws InterruptedException {
        Scoreboard scoreboard = new Scoreboard();
        int antalVinnare = 0;
        boolean fleraVinnare = false;


        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (Spelare.nySpelareArr.get(0).totalSumma == Spelare.nySpelareArr.get(i).totalSumma) {
                Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 1;
                System.out.println(Spelare.nySpelareArr.get(i).namn + " " + Spelare.nySpelareArr.get(i).isPlayerKeepTrue);
                antalVinnare = antalVinnare + Spelare.nySpelareArr.get(i).isPlayerKeepTrue;
            }
        }

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            if (antalVinnare > 1) {
                fleraVinnare = true;
                break;
            }
        }

        if (fleraVinnare) {
            System.out.println("Vi har flera vinnare! ");
            System.out.println("Är alla vinnare [J] eller vill ni rulla igen [N]? J//N");

            fleraVinnare2();

        } else {
            System.out.println("\n \u001B[1;33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE:\u001B[0m " + Spelare.nySpelareArr.get(0).namn
                    + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
        }
    }


    public void fleraVinnare2() throws InterruptedException {

        StartUpGame startUpGame = new StartUpGame();
        Scoreboard scoreboard = new Scoreboard();
        String fleraVinnareVal = Input.stringInput();
        boolean testLoop = true;
        int sizeOfArrayList = Spelare.nySpelareArr.size();
        //int catchPlayerRemoval = -1;


            if (fleraVinnareVal.toLowerCase().equals("j")) {
                System.out.println("Alla vann!");
                //gör en alla vann-metod som kallas på här
            } else if (fleraVinnareVal.toLowerCase().equals("n") && Spelare.nySpelareArr.size() > 1) {

                startUpGame.utslagsGame();
                System.out.println("OK - Då kastar vi igen om: ");
                scoreboard.sortSpelarLista();

                for (int i = 0; i < sizeOfArrayList; i++) {

                    if (Spelare.nySpelareArr.get(i).isPlayerKeepTrue == 0) {
                        Spelare.nySpelareArr.remove(i);
                        //catchPlayerRemoval++;
                    }
                    System.out.println((i + 1) + "...");
                    Thread.sleep(1000);
                }
                scoreboard.scoreboard();
                whileWinner();
                //kalla på en metod som håller det här istället -> känns som att koden bara blir bulkig av fortsätta här i?

            } else {
                System.out.println("Välj rätt input!");

        }

    }

    public void whileWinner() {

    }






    public void fleraVinnare() throws InterruptedException {
        StartUpGame startUpGame = new StartUpGame();
        Tarningar tarningar = new Tarningar();
        Scoreboard scoreboard = new Scoreboard();
        String fleraVinnareVal = Input.stringInput();
        boolean isStillWinners = true;
        //den slutar bara, behöver loopa om det här så att det körs tills vi är klara...


        if (fleraVinnareVal.toLowerCase().equals("j")) {

            System.out.println("Grattis ni alla vann!");
            for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {

                if (Spelare.nySpelareArr.get(i).isPlayerKeepTrue == 1 && fleraVinnareVal.toLowerCase().equals("j")) {

                    System.out.println(Spelare.nySpelareArr.get(i).namn + " med: " + Spelare.nySpelareArr.get(i).totalSumma);
                } else {
                }

            }
            System.out.println("Bra spelat!");
        } else {
            System.out.println("OK - Då kastar vi igen om: ");
            scoreboard.sortSpelarLista();
            while (isStillWinners)
                //den tar bort sin egna storlek, för varje element jag tar bort gör jag storleken mindre...
                //räkna antalen borttagna?
                for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {

                    if (Spelare.nySpelareArr.get(i).isPlayerKeepTrue == 0) {

                        Spelare.nySpelareArr.remove(i);
                    }
                    System.out.println((i + 1) + "...");
                    Thread.sleep(1000);
                }

            // verkar inte alls fungera här... tror jag får köra en if bool i case2??
            scoreboard.sortSpelarLista();
            scoreboard.scoreboard();
            startUpGame.utslagsGame();
            tarningar.tarningarArray2(tarningar.antalSidorClass, tarningar.antalTarningarClass, Spelare.nySpelareArr.size());
        }
    }
}





/*
if (isPlayerOneTrue) {
scoreboard.scoreboard();
System.out.println("\n \u001B[1;32m -----VINNAREN ÄR---- \u001B[0m ");
System.out.println("\033[1;33m SPELARE: \u001B[0m " + Spelare.nySpelareArr.get(0).namn + " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");
} else {
System.out.println("Vi har flera vinnare!");
System.out.println(Spelare.nySpelareArr);
scoreboard.scoreboard();


//fyll ut här med att ta genom det sista innan spelet slutas!
//presentera en vinnare här med så att vi vet att någon vann!

//få in en jämförelse mellan vinnaren och de undre! Så om 3st rullar 1 1 1, då har ju alla vunnit, eller ingen vunnit!

scoreboard.scoreboard();

System.out.println("\n \u001B[33m -----VINNAREN ÄR---- \n\033[1;33m SPELARE: \u001B[0m " + Spelare.nySpelareArr.get(0).namn
+ " med: " + Spelare.nySpelareArr.get(0).totalSumma + " poäng! \n Gratulerar!");


isPlaying = false;
*/