package com.AlexanderHasslund.demo;

public class SpelarData {

    int sparaAntalSpelare;
    public static int antalRundor;
    public int sparaAntalSpelare() {
        System.out.println("Hur många spelare? ");
        int sparaAntalSpelare = Input.intInput();
        this.sparaAntalSpelare = sparaAntalSpelare;
        return sparaAntalSpelare;
    }
    public int sparaAntalRundor() {
        System.out.println("Hur många rundor? ");
        int antalRundor = Input.intInput();
        this.antalRundor = antalRundor;
        return antalRundor;
        // Spelare nySpelare = new Spelare("", 0, 0, 0);
    }

    public void reggaSpelare() {
        SpelarData spelarData = new SpelarData();
        Spelare nySpelare = new Spelare("", 0, 0, 0);
        System.out.println("Ange namn och ålder för vardera spelare: ");

        for (int i = 0; i < sparaAntalSpelare; i++) {

            System.out.print("Namn Spelare " + (i + 1) + ": ");
            String namn = Input.stringInput();
            System.out.print("Ålder Spelare " + (i + 1) + ": ");
            int alder = Input.intInput();
            int uniktSpelarId = i + 1;

            nySpelare = new Spelare(namn, alder, uniktSpelarId, 0);
            Spelare.nySpelareArr.add(nySpelare);
        }
    }

    public void reggadSpelare() {
        System.out.println(String.format("\n%-20s", "\033[1;33m --- SPELARE ---"));

        //fungerar bra men formeringen kanske ska flyttas? Ser fluffigt ut
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            int uniktSpelarId = i + 1;

            //desto mer jag fyller ut, desto mer känner jag att det behövs flyttas ut till: interaktionsStruktur
            System.out.print("\033[1;33mSPELARE " + uniktSpelarId + "\u001B[0m ");
            System.out.println(Spelare.nySpelareArr.get(i).toString());
        }
    }
}
