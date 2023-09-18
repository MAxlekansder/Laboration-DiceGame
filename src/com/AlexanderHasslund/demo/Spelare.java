package com.AlexanderHasslund.demo;

public class Spelare {

    String namn;
    int alder;
    int spelareId;

    public Spelare(String name, int age) {
        this.namn = name;
        this.alder = age;
        this.spelareId = spelareId;
        arrayList();
        //bygg en for-loop här som lägger till unika ID per spelare för att sen kunna söka
        /*
        for (int i = 0; i < Spelare.length; i++) {
            this.spelareId = spelareId[i +1]
        {

        for (int i = 0; i < Spelare.spelare().length; i++) {
            this.spelarId = Spelare.spelare()[i +1] ;
         */
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

