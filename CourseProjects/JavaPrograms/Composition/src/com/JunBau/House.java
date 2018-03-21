package com.JunBau;

public class House {

    private int doors;
    private int rooms;
    private boolean garden;
    private room Room;

    public House(int doors, int rooms, boolean garden, room room) {
        this.doors = doors;
        this.rooms = rooms;
        this.garden = garden;
        Room = room;
    }

    public boolean isGarden() {
        return garden;
    }
}
