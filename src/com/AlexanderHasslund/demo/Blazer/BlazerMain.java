package com.AlexanderHasslund.demo.Blazer;
import com.AlexanderHasslund.demo.SpelarLogik;
import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import com.AlexanderHasslund.demo.Spelare;
import com.AlexanderHasslund.demo.interaktionsStruktur.Menyer;
import com.AlexanderHasslund.demo.interaktionsStruktur.SpelarInfoMeddelanden;

public class BlazerMain {

    public void blazerMain() throws InterruptedException {
        SpelarInfoMeddelanden spelarInfoMeddelanden = new SpelarInfoMeddelanden();
        Menyer menyer = new Menyer();
        BlazerTarning blazerTarning = new BlazerTarning();
        spelarInfoMeddelanden.blazerGame();

        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).totalSumma = 0;
        }
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
        }


        do {
            menyer.menuBlazer();
            int användarValBlazer = Input.intInput();
            switch (användarValBlazer) {
                case 1:
                    // kasta tärningblazer

                    blazerTarning.antalOmgångar();
                    SpelarLogik.isPlayingBlazer = false;
                    SpelarLogik.isPlaying = false;
                    break;

                case 2:
                    SpelarLogik.isPlayingBlazer = false;
                    SpelarLogik.isPlaying = false;
                    break;
            }
        } while(SpelarLogik.isPlayingBlazer);
    }
}
