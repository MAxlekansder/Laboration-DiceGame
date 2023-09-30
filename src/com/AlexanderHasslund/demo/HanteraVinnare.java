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
        Tarningar tarningar = new Tarningar();
        StartUpGame startUpGame = new StartUpGame();
        Scoreboard scoreboard = new Scoreboard();
        String fleraVinnareVal = Input.stringInput();
        boolean testLoop = true;
        int sizeOfArrayList = Spelare.nySpelareArr.size();

        startUpGame.utslagsGame();

           do {
               int catchPlayerRemoval = 0;
               if (fleraVinnareVal.toLowerCase().equals("j")) {
                   System.out.println("Alla vann!");
                   //gör en alla vann-metod som kallas på här
               } else if (fleraVinnareVal.toLowerCase().equals("n") && Spelare.nySpelareArr.size() > 1) {

                   System.out.println("OK - Då kastar vi igen om: ");

                   //kommer behövas logik för att förhindra att den bara repeterar 1 hela tiden.
                   //enklast är väl att bygga en struktur för "utslagsrundan"
                   Spelare.nySpelareArr.removeIf(n ->(n.isPlayerKeepTrue == 0));
                   scoreboard.sortSpelarLista();

                    //egen metod för läsvänlighetens skull?
                   for (int i = 0; i < 3; i++) {
                       System.out.println((i + 1) + "...");
                       Thread.sleep(1000);
                   }


                   if (Spelare.nySpelareArr.size() > 1) {
                       testLoop = true;
                       for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
                           Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
                       }
                       scoreboard.scoreboard();
                       tarningar.tarningarArray2(tarningar.getAntalTarningar(), tarningar.getSidorTarningar(), Spelare.nySpelareArr.size());
                       hanteraVinnare();
                   } else { testLoop = false;

                       hanteraVinnare();
                   }
                   //kalla på en metod som håller det här istället -> känns som att koden bara blir bulkig av fortsätta här i?

               } else {
                   System.out.println("Välj rätt input!");
               }

               //vi behöver kasta tärningar här inne igen
           } while (testLoop);
        }
}

