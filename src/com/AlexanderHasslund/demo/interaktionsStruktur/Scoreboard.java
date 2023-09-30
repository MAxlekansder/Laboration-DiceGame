package com.AlexanderHasslund.demo.interaktionsStruktur;
import com.AlexanderHasslund.demo.SpelarData;
import com.AlexanderHasslund.demo.Spelare;
import com.AlexanderHasslund.demo.Tarningar;
import java.util.Collections;
import java.util.Comparator;


public class Scoreboard{
    public void scoreboard() {
        SpelarData spelarData = new SpelarData();

        System.out.println(String.format("\n%-20s", "\033[1;33m --- SCOREBOARD  RUNDA "+ Tarningar.turer + " av " + spelarData.antalRundor + " ---\u001B[0m "));

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {

            System.out.print("\033[1;33mSPELARE " + Spelare.nySpelareArr.get(i).uniktSpelarId + "\u001B[0m ");
            System.out.println(Spelare.nySpelareArr.get(i).toString());

        }
    }
    public void sortSpelarLista() {
        Collections.sort(Spelare.nySpelareArr, new Comparator<Spelare>() {
            @Override
            public int compare(Spelare o1, Spelare o2) {

                return Integer.compare(o2.totalSumma, o1.totalSumma);
            }
        });
    }
}

