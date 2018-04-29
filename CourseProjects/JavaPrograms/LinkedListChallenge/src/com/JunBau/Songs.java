package com.JunBau;

public class Songs {

    private String SongName;
    private int SongDuration;

    private Songs(String songName, int songDuration) {
        this.SongName = songName;
        this.SongDuration = songDuration;
    }

    public String getSongName() {
        return SongName;
    }

    public int getSongDuration() {
        return SongDuration;
    }

    public static Songs addSong(String name, int duration) {
        return new Songs(name,duration);
    }
}
