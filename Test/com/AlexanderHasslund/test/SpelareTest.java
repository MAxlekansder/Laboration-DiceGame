package com.AlexanderHasslund.test;
import com.AlexanderHasslund.demo.Spelare;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SpelareTest {

    public static ArrayList<SpelareTest> nySpelareArrTest = new ArrayList<SpelareTest>();
    public String namn;
    int alder;
    public int totalSumma;
    public int uniktSpelarId;
    public int isPlayerKeepTrue;

    //konstruktor för att kunna skapa upp spelaren
    public SpelareTest(String namn, int alder, int uniktSpelarId, int totalSumma) { //<-- tog bort int totalSumma...

        this.namn = namn;
        this.alder = alder;
        this.uniktSpelarId = uniktSpelarId;
        this.isPlayerKeepTrue = 0;
        //this.totalSumma = totalSumma;
    }
    public String toString() {
        return (
                "Namn: " + this.namn.toUpperCase() + " || " +
                        "Unikt spelarId: " + this.uniktSpelarId + " || " +
                        "Ålder: " + this.alder + " || " +
                        "Summa tärningar: " + this.totalSumma + " || "
                // + "Sant: " + this.isPlayerKeepTrue //<-- ta bort den härifrån sen, bara för logik i backendsyfte...
        );
    }

}