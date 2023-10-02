package com.AlexanderHasslund.demo.interaktionsStruktur;

public class Menyer {
    public static boolean isPlaying = true;
    public boolean isFinalPlaying = true;
    public boolean isPlayingBlazer = true;

    public void menu() {

        //Kan vara bra att se över vilka val det ska vara
        System.out.println("\n\u001B[1;34m------------------------------");
        System.out.println("1. REGISTRERA SPELARE");
        System.out.println("2. KASTA TÄRNINGAR");
        System.out.println("3. GAME MODE: BLAZER ");
        System.out.println("4. SCOREBOARD");
        System.out.println("5. AVSLUTA SPELET");
        System.out.println("------------------------------\n\u001B[0m");
        System.out.print("Ditt val: ");
    }

    public void menuBlazer() {

        //Kan vara bra att se över vilka val det ska vara
        System.out.println("\n\u001B[1;34m------------------------------");
        System.out.println("1. STARTA BLAZER");
        System.out.println("2. SCOREBOARD");
        System.out.println("3. AVSLUTA SPELET");
        System.out.println("------------------------------\u001B[0m");
        System.out.print("Ditt val: ");
    }

}

