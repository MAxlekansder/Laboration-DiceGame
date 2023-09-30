package com.AlexanderHasslund.demo.interaktionsStruktur;
import com.AlexanderHasslund.demo.Input;
import com.AlexanderHasslund.demo.Spelare;

public class StartUpGame {
    public boolean isPlaying = true;
    public void startUpGame() {

        System.out.println("\n\u001B[1;33m\n\n------------------------------");
        System.out.println("Välkommen till tärningsspelet!!" );
        System.out.println("Det här spelet har två spelalternativ");
        System.out.println("Alternativet att välja tärning och sidor");
        System.out.println("Samt spelet: BLAZER [BETA]");
        System.out.println("------------------------------\n\u001B[0m");
    }

    public void utslagsGame() throws InterruptedException {
        System.out.println("\n\u001B[1;33m\n\n------------------------------");
        System.out.println("Välkommen till Utslagsrondan!!" );
        System.out.println("Nu nollställs alla poäng" );
        System.out.println("Lika många tärningar och lika många sidor!" );
        System.out.println("och ni alla som gick vidare");
        System.out.println("börjar nu om på noll!\n");
        System.out.println("Vilket betyder att ni inte kommer kunna");
        System.out.println("spela igen, i slutet av spelet\n");
        System.out.println("Det här är en utslagstävlning");
        System.out.println("med endast en vinnare");
        System.out.println("------------------------------\n\u001B[0m");

        Thread.sleep(2000);
        System.out.println("Lycka till...");

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).totalSumma = 0;
        }
    }

    public void endingGame() {
        System.out.println("Spela igen? J/N");
        String spelaIgen = Input.stringInput();
        if (spelaIgen.toLowerCase().equals("j")) {
            isPlaying = true;
        } else { isPlaying = false;}

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
            Spelare.nySpelareArr.get(i).totalSumma = 0;
        }

    }

    public void menu() {

        //Kan vara bra att se över vilka val det ska vara
        System.out.println("\n\u001B[1;34m1. REGISTRERA SPELARE");
        System.out.println("2. KASTA TÄRNINGAR");
        System.out.println("3. GAME MODE: BLAZER ");
        System.out.println("4. SCOREBOARD");
        System.out.println("5. AVSLUTA SPELET\u001B[0m");
        System.out.print("Ditt val: ");

    }
}
//Släng in kanske färger o grejer?