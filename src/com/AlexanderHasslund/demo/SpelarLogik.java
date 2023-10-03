package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Input;

public class SpelarLogik {

    public static int sparaAntalSpelare;
    public static int antalRundor;
    public static boolean isPlaying = true;
    public static boolean isPlayingBlazer = true;

    //check om endast en spelare
    public void checkAntalSpelare() throws InterruptedException {
        if (sparaAntalSpelare == 1) {
            System.out.println("\n\033[1;37mDet är roligare att spela med fler \nMen det går bra att spela själv med! \nHa så kul!\033[0m");
            Thread.sleep(1500);
        }

    }

    //lagrar värdet och håller det i den statiska attri i klassen, för att kunna spela flera gånger med samma värden...
    public void sparaAntalSpelare() {
        System.out.println("Hur många spelare? ");
        int sparaAntalSpelare = Input.intInput();
        this.sparaAntalSpelare = sparaAntalSpelare;
    }

    // -||-
    public void sparaAntalRundor() {
        System.out.println("Hur många rundor? OBS GÄLLER EJ BLAZER!");
        int antalRundor = Input.intInput();
        this.antalRundor = antalRundor;
    }

    //skapar spelaren här -> baserat på antal spelare som valts, 1 eller 100...
    public void reggaSpelare() {
        boolean catchNamnInput = true;
        Spelare nySpelare;
        String namn;

        System.out.println("Ange namn och ålder för vardera spelare: ");
        for (int i = 0; i < sparaAntalSpelare; i++) {

            do {
                System.out.print("Namn Spelare " + (i + 1) + ": ");
                namn = Input.stringInput();

                if (!namn.isEmpty() || !namn.isBlank()) {
                    catchNamnInput = false;
                } else {
                    System.out.println("Du måste skriva ditt namn!");
                }

            } while (catchNamnInput);

            System.out.print("Ålder Spelare " + (i + 1) + ": ");
            int alder = Input.intInput();
            int uniktSpelarId = i + 1;

            nySpelare = new Spelare(namn, alder, uniktSpelarId, 0);
            Spelare.nySpelareArr.add(nySpelare);
            catchNamnInput = true;
        }
    }
    // printar bara registrerade spelare
    public void reggadSpelare() {
        System.out.printf("\n%-20s%n", "\033[1;33m --- SPELARE ---");

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            int uniktSpelarId = i + 1;

            System.out.print("\033[1;33mSPELARE " + uniktSpelarId + "\u001B[0m ");
            System.out.println(Spelare.nySpelareArr.get(i).toString());
        }
    }
}
