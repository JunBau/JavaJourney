package com.JunBau;

public class Lights {

    private String lightColour;
    private String lightBrightness;

    public Lights(String lightColour, String lightBrightness) {
        this.lightColour = lightColour;
        this.lightBrightness = lightBrightness;
    }

    public void turnOn(){
        System.out.println("The lamp is now on.");
    }
}
