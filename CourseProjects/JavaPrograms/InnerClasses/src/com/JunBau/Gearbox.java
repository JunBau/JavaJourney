package com.JunBau;

import java.util.ArrayList;

public class Gearbox {

    private ArrayList<Gear> Gears;
    private int MaxGears;
    private int CurrentGear = 0;
    private boolean ClutchIsIn;

    public Gearbox(int MaxGears) {
        this.MaxGears = MaxGears;
        this.Gears = new ArrayList<>();
        Gear Neutral = new Gear(0, 0.0);
        this.Gears.add(Neutral);

        for (int i = 0; i < MaxGears; i++) {
            AddGear(i, i* 5.3);
        }
    }

    public void OperateClutch(boolean in) {
        this.ClutchIsIn = in;
    }

    public void AddGear (int number, double ratio) {
        if(number > 0 && number <= MaxGears) {
            this.Gears.add(new Gear(number, ratio));
        }
    }

    public void ChangeGear(int newGear) {
        if(newGear >= 0 && newGear < this.Gears.size() && this.ClutchIsIn) {
            this.CurrentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind!");
            this.CurrentGear = 0;
        }
    }

    public double WheelSpeed (int revs) {
        if(ClutchIsIn) {
            System.out.println("Scream!!!");
            return 0.0;
        }
        return revs * Gears.get(CurrentGear).getRatio();
    }

    // Inner Class, could be good for encapsulation:-

    private class Gear {
        private int GearNumber;
        private double Ratio;

        public double getRatio() {
            return Ratio;
        }

        public Gear(int gearNumber, double ratio) {
            this.GearNumber = gearNumber;
            this.Ratio = ratio;
        }

        public double DriveSpeed(int revs) {
            return revs *(this.Ratio);
        }
    }

}
