package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Menu;
import com.AlexanderHasslund.demo.interaktionsStruktur.StartUpGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatWidthException;

public class Main {
    public static void main(String[] args) {
        //instansiera allt här
        Menu myMenu = new Menu();
        Tarningar tarning = new Tarningar();

        StartUpGame.startUpGame();

        System.out.println("Hur många spelare? ");
        int sparaAntalSpelare = Input.intInput();

        /* TODO PLACEHOLDER FÖR SPELARE*/


        boolean isPlaying = true;


        do {
            try{
                //kallar på menyvalen i klass Menu
                myMenu.menu();
                int användarVal = Input.intInput();

                switch (användarVal) {
                    case 1:
                        //System.out.println("Ange namn och ålder på spelaren nedan!: ");
                        //Spelare nySpelare = new Spelare(Input.stringInput(), Input.intInput());
                        //jag vill nog ha vardera spelare bunden till antalet spelare?
                        //System.out.println(nySpelare.toString());

                        //det här stycket skapar spelare baserat på antalet som spelar --> skriver till klass Spelare
                        ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();
                        for (int i = 0; i < sparaAntalSpelare; i++) {
                            System.out.println("Ange namn och ålder för vardera spelare: ");
                            Spelare nySpelare = new Spelare(Input.stringInput(), Input.intInput());
                            nySpelareArr.add(nySpelare);
                        }
                        System.out.println("Det här är ArrayList --> " + Arrays.deepToString(nySpelareArr.toArray()));
                        System.out.println("Det här är ArrayList 2 --> "+ nySpelareArr.toString());
                        System.out.println("Det här är ArrayList 3 --> " + nySpelareArr);
                        for (int i = 0; i < nySpelareArr.size(); i++) {
                            System.out.println(i);
                            //System.out.println(Arrays.deepToString(list.));
                            System.out.println(nySpelareArr.get(i));
                            System.out.println("i for-loopen --> " + nySpelareArr);
                            System.out.println(nySpelareArr.get(0));
                            System.out.println(nySpelareArr.get(1));
                        }
                        //lägg spelare här eller innan?
                        // släng in namnen här istället där uppe <--
                        break;

                    case 2:
                        System.out.println("Hur många sidor ska tärningen ha?");
                        int sparadSida = tarning.sidorTarningar();
                        System.out.println(sparadSida);

                        System.out.println("Hur många tärningar ska kastas per spelare?");
                        int sparatAntal = tarning.antalTarningar();
                        System.out.println(sparatAntal);

                        System.out.println("check");
                        tarning.tarningarArray(sparatAntal, sparadSida);

                        //välja antalet tärningar
                        //rulla här med? ta med if ()
                        break;
                    case 3:
                        //rulla här eller i case 2?
                        //kombinera spelare och tärningar
                        break;
                    case 4:
                        //återkalla scoreboard, vem leder? Ta med sort och räkna ihop
                        //kan vi skapa en scoreboard?
                        //sortera också - inkludera här -> fixa en bineary search
                        /* FIXME KÖR TVÅ GAME MODES!! SÄTT IN EN UTSLAGSTÄVLING! DÄR VI KÖR ARRAYLIST.POP */
                        break;
                    case 5:
                        System.out.println("Tack för att du spelade!");
                        isPlaying = false;
                        break;
                    default:
                        System.out.println("Håll dig inom angivna valen");
                }
            //se över om vi kan ta bort try catch...
            //fångar om användaren skriver in något annat - en sista failsafe, existerar redna en try i inten
            }catch(MissingFormatWidthException e)
            {
                System.out.println("Använd dig av heltal för att navigera menyn!"); }
        //do while körs så länge vi inte stänger ner det -> breakar case x:
        } while (isPlaying);



    }
}

