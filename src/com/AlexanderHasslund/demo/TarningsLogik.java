package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;

public class TarningsLogik {
    int sparadSida;
    int sparatAntal;

    public void checkaOchKasta() {
        Tarningar tarning = new Tarningar();
        SpelarData spelarData = new SpelarData();
        Scoreboard scoreboard = new Scoreboard();


        if (sparadSida == 0) {
            System.out.println("Hur många sidor ska tärningen ha?");
            sparadSida = Input.intInput();
            tarning.setSidorTarningar(sparadSida);
        }

        if (sparatAntal == 0) {
            System.out.println("Hur många tärningar ska kastas per spelare?");
            sparatAntal = Input.intInput();
            tarning.setAntalTarningar(sparatAntal);
        }

        tarning.tarningarArray2(sparatAntal, sparadSida, SpelarData.sparaAntalSpelare);
        scoreboard.sortSpelarLista();
    }
}
