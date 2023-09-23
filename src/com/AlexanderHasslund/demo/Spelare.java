package com.AlexanderHasslund.demo;

import java.util.ArrayList;

public class Spelare {

    String namn;
    int alder;
    int totalSumma;
    int uniktSpelarId;


    //går att stoppa in en array hör för att använda sig av det vid tilldeningen till spelareId
    public Spelare(String namn, int alder, int uniktSpelarId, int totalSumma) { //<-- tog bort int totalSumma...
        Tarningar tarning = new Tarningar();
        this.namn = namn;
        this.alder = alder;
        this.uniktSpelarId = uniktSpelarId;
        this.totalSumma = totalSumma;
        //känns som att den här kommer att förstöra för mig senare
        //int totalSumma = 0;
        //försök att få in uniktId här med
        //int UniktId =
        //this.totalSumma = totalSumma

    }



    //används för att overrida så att objekten i arraylist printas...
   public String toString() {
        return (
                "Namn: " + this.namn.toUpperCase() + " || " +
                "Unikt spelarId: " + this.uniktSpelarId + " || " +
                "Ålder: "+ this.alder + " || " +
                "Summa tärningar: " + this.totalSumma
                 //+ "\n"
                );
        //bästa stället att lagra allt om spelaren här?
    }
    //här kan vi sätta ut direkta summan och summera ihop alla kast per spelare!

    public int sumTotalPoang(int totalSumma) {
        //stoppa in summan av arrayen / tärningarna här -> därför finns det en parameter
        return this.totalSumma = totalSumma;
    }

    public void spelareArr() {

        //ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();

    }

    /*TODO ÅTERKALLA EN METOD FÖR ATT SPARA SPELAREN I ARRAY?
    public SpelareArr(String[] namnArr, int[] alderArr) {
        this.namnArr = namnArr;
        this.alderArr = alderArr;
    }*/

    //se över om det ska läggas till som en parameter
    public int spelareAntal() {
        int antalSpelare = Input.intInput();
        return antalSpelare;
    }

    //bör hålla det här för att sen kunna dela upp det

    public void arrayList() {
        ArrayList<Spelare> nySpelareArr = new ArrayList<Spelare>();
    }

        //arrayList(); <-- efter att vi har delat allt, se till att försöka spara allt i en array?

        //bygg en for-loop här som lägger till unika ID per spelare för att sen kunna söka
        /*
        for (int i = 0; i < Spelare.length; i++) {
            this.spelareId = spelareId[i +1]
        {

        for (int i = 0; i < Spelare.spelare().length; i++) {
            this.spelarId = Spelare.spelare()[i +1] ;
         */

}

