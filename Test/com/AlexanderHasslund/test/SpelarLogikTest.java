package com.AlexanderHasslund.test;

import com.AlexanderHasslund.demo.Spelare;
import com.AlexanderHasslund.demo.interaktionsStruktur.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpelarLogikTest {

    @Test
    public void reggaSpelareTest() {
        SpelareTest spelareTest;

        String namn = "Alexander";
        int alder = 30;
        int uniktSpelarId = 1;

        spelareTest = new SpelareTest(namn, alder, uniktSpelarId, 0);
        assertNotNull(spelareTest);
        SpelareTest.nySpelareArrTest.add(spelareTest);

        System.out.println(SpelareTest.nySpelareArrTest.get(0));
        assertFalse(SpelareTest.nySpelareArrTest.isEmpty());


    }
    @Test
    public void resetSpelareSummaTest() {
        SpelareTest spelareTest;

        String namn = "Alexander";
        int alder = 30;
        int uniktSpelarId = 1;

        spelareTest = new SpelareTest(namn, alder, uniktSpelarId, 0);
        SpelareTest.nySpelareArrTest.add(spelareTest);

        SpelareTest.nySpelareArrTest.get(0).totalSumma = 18;
        SpelareTest.nySpelareArrTest.get(0).isPlayerKeepTrue = 1;

        System.out.println(SpelareTest.nySpelareArrTest);

        for (int i = 0; i < SpelareTest.nySpelareArrTest.size(); i++) {
            SpelareTest.nySpelareArrTest.get(i).totalSumma = 0;
            assertEquals(0, SpelareTest.nySpelareArrTest.get(i).totalSumma);
        }
        for (int i = 0; i < Spelare.nySpelareArr.size(); i++) {
            Spelare.nySpelareArr.get(i).isPlayerKeepTrue = 0;
            assertEquals(0, SpelareTest.nySpelareArrTest.get(i).isPlayerKeepTrue);
        }

        System.out.println(SpelareTest.nySpelareArrTest);
    }
}