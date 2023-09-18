package com.AlexanderHasslund.demo;

public class Main {
    public static void main(String[] args) {

        //jag vill nog ha vardera spelare bunden till antalet spelare?

        System.out.println("test string");
        Input.stringInput();

        System.out.println("test int");
        Input.intInput();
        System.out.println("Test över");
        //Spelare unikSpelare = new Spelare("Tjena",123);


        //funkar som tänkt.
        Spelare spelar = new Spelare(Input.stringInput(), Input.intInput());
        System.out.println(spelar);



    }
}
