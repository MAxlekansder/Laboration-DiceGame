package com.AlexanderHasslund.demo.interaktionsStruktur;
import com.AlexanderHasslund.demo.Main;
import com.AlexanderHasslund.demo.Spelare;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Scoreboard{
    public void scoreboard() {

        System.out.println(String.format("\n%-20s", "\033[1;33m --- SCOREBOARD --- \u001B[0m "));

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {

            System.out.print("\033[1;33mSPELARE " + Spelare.nySpelareArr.get(i).uniktSpelarId + "\u001B[0m ");
            System.out.println(Spelare.nySpelareArr.get(i).toString());

        }
    }
    public void sortSpelarLista() {
        Collections.sort(Spelare.nySpelareArr, new Comparator<Spelare>() {
            @Override
            public int compare(Spelare o1, Spelare o2) {
                /*
                //hanterar isPlayerRemovedTruehär inne för att göra allt direkt i jämförelsen. Vi byter redan här
                if (o2.totalSumma == o1.totalSumma) {
                    for (int i = 0; i < Spelare.nySpelareArr.size();i++) {
                        Spelare.nySpelareArr.get(i).isPlayerRemoveTrue = true;
                        //verkar inte funka...

                    }
                }*/
                return Integer.compare(o2.totalSumma, o1.totalSumma);
            }
        });

    }


    //funtar på om man ska slänga in en sortering här eller utanför
    //kanske kalla på metoder här för att sen sortera utifrån användarens val
    //IF-a om vi att användaren ska sortera eller inte...

    //Se sen om vi också kan flytta in spelare här för att sortera ut det

}

