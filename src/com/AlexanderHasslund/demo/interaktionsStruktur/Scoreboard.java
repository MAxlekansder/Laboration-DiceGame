package com.AlexanderHasslund.demo.interaktionsStruktur;

import com.AlexanderHasslund.demo.Main;
import com.AlexanderHasslund.demo.Spelare;


public class Scoreboard {
    public void scoreboard() {
        //Spelare nySpelare = new Spelare();
        System.out.println(String.format("\n%-20s", "\033[1;33m --- SCOREBOARD --- \u001B[0m "));

        //fungerar bra men formeringen kanske ska flyttas? Ser fluffigt ut
        for (int i = 0; i < Main.nySpelareArr.size(); i++) {
            int uniktSpelarId = i + 1;

            //desto mer jag fyller ut, desto mer känner jag att det behövs flyttas ut till: interaktionsStruktur
            System.out.print("\033[1;33mSPELARE " + uniktSpelarId + "\u001B[0m ");
            System.out.println(Main.nySpelareArr.get(i).toString());


           // if (Main.nySpelareArr.get(i).totalSumma == Main.nySpelareArr.get(i + 1).totalSumma) {


        }



    }


    //funtar på om man ska slänga in en sortering här eller utanför
    //kanske kalla på metoder här för att sen sortera utifrån användarens val
    //IF-a om vi att användaren ska sortera eller inte...

    //Se sen om vi också kan flytta in spelare här för att sortera ut det

}

