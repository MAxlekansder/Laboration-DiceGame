package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Input;

import java.util.ArrayList;

//definierar spelaren och arraylisten för att hålla spelaren
public class Spelare {

    //arraylist object -> inte bunden till en datatyp
    public static ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();
    public String namn;
    int alder;
    public int totalSumma;
    public int uniktSpelarId;
    public int isPlayerKeepTrue;

    //konstruktor för att kunna skapa upp spelaren
    public Spelare(String namn, int alder, int uniktSpelarId, int totalSumma) { //<-- tog bort int totalSumma...

        this.namn = namn;
        this.alder = alder;
        this.uniktSpelarId = uniktSpelarId;
        this.isPlayerKeepTrue = 0;
        //this.totalSumma = totalSumma;
    }

    //används för att overrida så att objekten i arraylist printas...
   public String toString() {
        return (
                "Namn: " + this.namn.toUpperCase() + " || " +
                "Unikt spelarId: " + this.uniktSpelarId + " || " +
                "Ålder: "+ this.alder + " || " +
                "Summa tärningar: " + this.totalSumma + " || " +
                "Sant: " + this.isPlayerKeepTrue //<-- ta bort den härifrån sen, bara för logik i backendsyfte...
                );
    }

    public int spelareAntal() {
        int antalSpelare = Input.intInput();
        return antalSpelare;
    }

}
