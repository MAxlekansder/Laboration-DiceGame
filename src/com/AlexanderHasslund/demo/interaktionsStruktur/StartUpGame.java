package com.AlexanderHasslund.demo.interaktionsStruktur;

import com.AlexanderHasslund.demo.Input;
import com.AlexanderHasslund.demo.Spelare;

import java.util.Scanner;

public class StartUpGame {

    public void startUpGame() {

        System.out.println("\n\u001B[1;33m\n\n------------------------------");
        System.out.println("Välkommen till spelet!" );
        System.out.println("Det här spelet har två spelalternativ");
        System.out.println("Alternativet att välja tärning och sidor");
        System.out.println("Samt spelet: BLAZER");
        System.out.println("------------------------------\n\u001B[0m");
    }

    public void utslagsGame() {
        System.out.println("\n\u001B[1;33m\n\n------------------------------");
        System.out.println("Välkommen till Utslagsrondan!!" );
        System.out.println("Nu nollställs alla poäng" );
        System.out.println("och ni alla som gick vidare");
        System.out.println("börjar nu om på noll!");
        System.out.println("------------------------------\n\u001B[0m");

        //flytta ut den här eftersom vi inte kommer återkalla denna varje gång?
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).totalSumma = 0;
        }
    }

    public void endingGame() {

    }

    public void menu() {

        //Kan vara bra att se över vilka val det ska vara
        System.out.println("\n\u001B[1;34m1. REGISTRERA SPELARE");
        System.out.println("2. BESTÄM ANTAL TÄRNINGAR OCH KASTA TÄRNINGAR");
        System.out.println("3. GAME MODE: BLAZER ");
        System.out.println("4. SCOREBOARD");
        System.out.println("5. AVSLUTA SPELET\u001B[0m");
        System.out.print("Ditt val: ");

    }
}
//Släng in kanske färger o grejer?