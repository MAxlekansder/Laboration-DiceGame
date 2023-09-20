package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.MissingFormatWidthException;

public class Main {
    public static void main(String[] args) {

        StartUpGame.startUpGame();

        System.out.println("Hur många spelare? ");
        int sparaAntalSpelare = Input.intInput();

        /* TODO PLACEHOLDER FÖR SPELARE*/
        System.out.println("Ange namn och ålder på spelaren nedan!: ");
        Spelare nySpelare = new Spelare(Input.stringInput(), Input.intInput());
        //jag vill nog ha vardera spelare bunden till antalet spelare?
        System.out.println(nySpelare.toString());

        boolean isPlaying = true;


        do {
            try{
                int användarVal = Input.intInput();
                switch (användarVal) {
                    case 1:
                        //lägg spelare här eller innan?
                        break;
                    case 2:
                        //välja antalet tärningar
                        //rulla här med? ta med if ()
                        break;
                    case 3:
                        //återkalla scoreboard, vem leder? Ta med sort och räkna ihop
                        //kan vi skapa en scoreboard?
                        break;
                    default:
                        System.out.println("Håll dig inom angivna valen");
                }
            }catch(MissingFormatWidthException e)
            {
                System.out.println("Använd dig av heltal för att navigera menyn!"); }

        } while (isPlaying);



    }
}

