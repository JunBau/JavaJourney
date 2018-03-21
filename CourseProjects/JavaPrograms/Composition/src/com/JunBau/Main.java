package com.JunBau;

public class Main {

    public static void main(String[] args) {

//        Dimensions dimensions = new Dimensions(20,20,5);
//        Case theCase = new Case("220B", "NZXT", "240", dimensions);
//
//
//        Monitor theMonitor = new Monitor("t400", "Hanns-G", 27,new Resolution(2540,1440));
//
//        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
//
//        PC thePC = new PC(theCase,theMonitor,theMotherboard);
//
//        thePC.powerUp();

        Dimensions dimensions = new Dimensions(50,40, 600);
        Floor floor = new Floor("Wooden", "Grey");
        Wall wall = new Wall ("Plaster", "White");
        Lights lights = new Lights("Blue", "High");
        Furniture bed = new Furniture(new Dimensions(12,40,20),"bed" );



     room Bedroom = new room ("Bedroom", dimensions, floor, bed, wall, lights );
     Bedroom.turnOnLight();
     Bedroom.getLights().turnOn();

    }
}
