package com.JunBau;

public class Song {

    private String SongName;
    private int SongDuration;

    private Song(String songName, int songDuration) {
        this.SongName = songName;
        this.SongDuration = songDuration;
    }

    public String getSongName() {
        return SongName;
    }

    public int getSongDuration() {
        return SongDuration;
    }

    public static Song addSong(String name, int duration) {
        return new Song(name,duration);
    }
}
