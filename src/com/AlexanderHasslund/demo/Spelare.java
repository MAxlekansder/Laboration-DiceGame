package com.AlexanderHasslund.demo;

public class Spelare {

    String namn;
    int alder;
    int spelareId;

    //går att stoppa in en array hör för att använda sig av det vid tilldeningen till spelareId
    public Spelare(String name, int age) {
        this.namn = name;
        this.alder = age;
        this.spelareId = spelareId;
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

    //se över om det ska läggas till som en parameter
    public static int spelareAntal() {
        int antalSpelare = Input.intInput();
        return antalSpelare;
    }

    //bör hålla det här för att sen kunna dela upp det
    public void arrayList() {

    }

    //placeholder
    public String toString() {
        return namn + " " + alder;

        //bästa stället att lagra allt om spelaren här?
    }
}

