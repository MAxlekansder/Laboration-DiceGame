package com.AlexanderHasslund.demo.interaktionsStruktur;

public class SpelarInfoMeddelanden {

    public void startUpGame() {

        System.out.println("\n\u001B[1;33m\n\n------------------------------");
        System.out.println("Välkommen till tärningsspelet!!" );
        System.out.println("Det här spelet har två spelalternativ!");
        System.out.println("Alternativet att välja tärning och sidor");
        System.out.println("Samt tärningsvarianten: BLAZER ");
        System.out.println("------------------------------\n\u001B[0m");
    }

    public void blazerGame() throws InterruptedException {
        Menyer menyer = new Menyer();

        menyer.isFinalPlaying = false;
        System.out.println("\n\u001B[1;34m------------------------------");
        System.out.println("VÄLKOMMEN TILL BLAZER!");
        Thread.sleep(2500);
        System.out.println("Alla spelare får en tärning");
        System.out.println("värdet på tärningen är 6");
        System.out.println("först till 21 vinner under 6 ronder\n");
        Thread.sleep(2500);
        System.out.println("Är du under 10 poäng efter 3 runder");
        System.out.println("Åker du ut!!\u001B[0m\n");
        System.out.println("------------------------------\u001B[0m");
        Thread.sleep(3500);
        System.out.println("...Lycka till!");
    }

    public void utslagsGame() throws InterruptedException {
        System.out.println("\n\u001B[1;33m\n\n------------------------------");
        System.out.println("Nu finns alternativet till Utslagsrondan!!" );
        System.out.println("där alla poäng nollställs!\n" );
        Thread.sleep(1500);
        System.out.println("Lika många tärningar och lika många sidor som tidigare!" );
        System.out.println("Ni som gick vidare börjar om på noll!\n");
        Thread.sleep(1500);
        System.out.println("Det här är en utslagstävlning");
        System.out.println("med endast en vinnare");
        System.out.println("------------------------------\n\u001B[0m");

    }


}
