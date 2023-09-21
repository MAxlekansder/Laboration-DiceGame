package com.AlexanderHasslund.demo;

public class Spelare {

    String namn;
    int alder;
    String[] namnArr;
    int[] alderArr;
    //int spelareId;

    //går att stoppa in en array hör för att använda sig av det vid tilldeningen till spelareId
    public Spelare(String namn, int alder) {
        this.namn = namn;
        this.alder = alder;

       // this.spelareId = spelareId;
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
    //används för att overrida så att objekten i arraylist printas...
  /*  public String toString() {
        return (
                " Namn " + this.namn + " " +
                "alder "+ this.alder
                );
        //bästa stället att lagra allt om spelaren här?
    }*/


    public void spelareArr() {


    }

    /*TODO ÅTERKALLA EN METOD FÖR ATT SPARA SPELAREN I ARRAY?
    public SpelareArr(String[] namnArr, int[] alderArr) {
        this.namnArr = namnArr;
        this.alderArr = alderArr;
    }*/

    //se över om det ska läggas till som en parameter
    public static int spelareAntal() {
        int antalSpelare = Input.intInput();
        return antalSpelare;
    }

    //bör hålla det här för att sen kunna dela upp det
    public void arrayList() {


    }
    /*
    //placeholder
     */
}

