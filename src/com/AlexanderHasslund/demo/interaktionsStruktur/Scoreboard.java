package com.AlexanderHasslund.demo.interaktionsStruktur;
import com.AlexanderHasslund.demo.Main;
import com.AlexanderHasslund.demo.Spelare;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Scoreboard{
    public void scoreboard() {

        System.out.println(String.format("\n%-20s", "\033[1;33m --- SCOREBOARD --- \u001B[0m "));

        //fungerar bra men formeringen kanske ska flyttas? Ser fluffigt ut
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            //int uniktSpelarId = i + 1;

            //desto mer jag fyller ut, desto mer känner jag att det behövs flyttas ut till: interaktionsStruktur
            System.out.print("\033[1;33mSPELARE " + Spelare.nySpelareArr.get(i).uniktSpelarId + "\u001B[0m ");
            System.out.println(Spelare.nySpelareArr.get(i).toString());

            // if (Main.nySpelareArr.get(i).totalSumma == Main.nySpelareArr.get(i + 1).totalSumma) {
        }
    }
    public void sortSpelarLista() {
        Collections.sort(Spelare.nySpelareArr, new Comparator<Spelare>() {
            @Override
            public int compare(Spelare o1, Spelare o2) {
                return Integer.compare(o2.totalSumma, o1.totalSumma);
            }
        });

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            System.out.println("Ny sortering: ");
        }
    }
    /*
    public void sortSpelarLista() {
        Collections.sort(Spelare.nySpelareArr, new Comparator<Spelare>() {
            @Override
            public int compare(Spelare o1, Spelare o2) {
                return Integer.compare(o1.totalSumma, o2.totalSumma);
            }
        });

        for (int i = 1; i < Spelare.nySpelareArr.get(i).uniktSpelarId; i++) {
            System.out.println("Ny sortering: " + Spelare.nySpelareArr.get(i).uniktSpelarId + Spelare.nySpelareArr.get(i).totalSumma);
        }
    }*/


    //funtar på om man ska slänga in en sortering här eller utanför
    //kanske kalla på metoder här för att sen sortera utifrån användarens val
    //IF-a om vi att användaren ska sortera eller inte...

    //Se sen om vi också kan flytta in spelare här för att sortera ut det

}

