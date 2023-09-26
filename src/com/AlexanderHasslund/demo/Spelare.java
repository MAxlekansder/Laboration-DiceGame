package com.AlexanderHasslund.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Spelare {

    public static ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();
    String namn;
    int alder;
    public int totalSumma;
    public int uniktSpelarId;
    public boolean isPlayerRemoveTrue;

    //går att stoppa in en array hör för att använda sig av det vid tilldeningen till spelareId
    public Spelare(String namn, int alder, int uniktSpelarId, int totalSumma) { //<-- tog bort int totalSumma...
        Tarningar tarning = new Tarningar();
        this.namn = namn;
        this.alder = alder;
        this.uniktSpelarId = uniktSpelarId;
        this.isPlayerRemoveTrue = false;
        //this.totalSumma = totalSumma;
    }



    //används för att overrida så att objekten i arraylist printas...
   public String toString() {
        return (
                "Namn: " + this.namn.toUpperCase() + " || " +
                "Unikt spelarId: " + this.uniktSpelarId + " || " +
                "Ålder: "+ this.alder + " || " +
                "Summa tärningar: " + this.totalSumma + " || " +
                "Sant: " + this.isPlayerRemoveTrue //<-- ta bort den härifrån sen, baraför backendsyfte...
                 //+ "\n"
                );
        //bästa stället att lagra allt om spelaren här?
    }
    //här kan vi sätta ut direkta summan och summera ihop alla kast per spelare!
    /*
    public int sumTotalPoang(int totalSumma) {
        Tarningar tarning = new Tarningar();
        //stoppa in summan av arrayen / tärningarna här -> därför finns det en parameter
        return this.totalSumma = tarning.tarningarArray2(0,0,totalSumma);
    }
    */
    public void spelareArr() {
        //ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();
    }

    //se över om det ska läggas till som en parameter
    public int spelareAntal() {
        int antalSpelare = Input.intInput();
        return antalSpelare;
    }

    //bör hålla det här för att sen kunna dela upp det


}
