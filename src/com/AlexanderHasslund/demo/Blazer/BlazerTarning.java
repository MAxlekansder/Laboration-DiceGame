package com.AlexanderHasslund.demo.Blazer;
import com.AlexanderHasslund.demo.Spelare;
import com.AlexanderHasslund.demo.Tarningar;
public class BlazerTarning {

    public void mainBlazerTarning() {
        Tarningar tarning = new Tarningar();
        tarning.tarningarArray(1,6,Spelare.nySpelareArr.size());
    }
}
