package com.AlexanderHasslund.demo;

import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import com.AlexanderHasslund.demo.interaktionsStruktur.Scoreboard;

//borde heta tarningsCheck men -> här kollar vi bara om vi redan har lagrat värdet och kastar igen
//tex om vi vill spela flera gånger inom samma spel
public class TarningsLogik {
    int sparadSida;
    int sparatAntal;

    public void checkaOchKasta() {
        Tarningar tarning = new Tarningar();
        Scoreboard scoreboard = new Scoreboard();
        boolean catchSidorInput = true;

        if (sparadSida == 0) {
            System.out.println("Hur många sidor ska tärningen ha?");
            do {
                sparadSida = Input.intInput();
                if (sparadSida > 1) {
                    catchSidorInput = false;
                } else {
                    System.out.println("En tärning kan inte bara ha en sida... Välj igen: ");
                }
            } while (catchSidorInput);
            tarning.setSidorTarningar(sparadSida);
        }
        if (sparatAntal == 0) {
            System.out.println("Hur många tärningar ska kastas per spelare?");
            sparatAntal = Input.intInput();
            tarning.setAntalTarningar(sparatAntal);
        }

        tarning.tarningarArray(sparatAntal, sparadSida, SpelarLogik.sparaAntalSpelare);
        scoreboard.sortSpelarLista();
    }
}
