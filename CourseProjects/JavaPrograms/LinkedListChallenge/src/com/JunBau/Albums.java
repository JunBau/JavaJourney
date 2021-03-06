package com.JunBau;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Albums {

    private String AlbumName;
    private LinkedList<Songs> AlbumTracks = new LinkedList<Songs>();

    private Albums(String albumName) {
        this.AlbumName = albumName;
    }

    public static Albums addAlbum (String name) {
        return new Albums(name);
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public int getSongDuration (String searchName) {
        return AlbumTracks.get(findTrack(searchName)).getSongDuration();
    }


    // Track interactions

    public void AddTrack (String TrackName, int duration) {
        AlbumTracks.add(Songs.addSong(TrackName,duration));
    }

    public void PrintTrackList () {
        Iterator<Songs> i = AlbumTracks.iterator();
        Iterator<Songs> o = AlbumTracks.iterator();
        while(i.hasNext() || o.hasNext()) {
            System.out.println("Track: " + i.next().getSongName() + "                    Duration: " + o.next().getSongDuration() + " Mins");
        }
        System.out.println("=============================================");
    }

    public boolean onFile (String searchName) {
        int position = findTrack(searchName);
        if(position >= 0) {
            return true;
        }
        return false;
    }

    // This is where the bug is. This for loop on the size works with ArrayList, but a LinkedList works differently...

    private int findTrack(String searchName) {

        for (int i = 0; i < AlbumTracks.size(); i++) {
            Songs track = AlbumTracks.get(i);
            if (track.getSongName().equals(searchName)) {
                return i;
            }
        }
        return -1;
    }

    // Playlist program

    public void PlayTrackList() {
        Scanner userinput = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Songs> listIteratorz = AlbumTracks.listIterator();
        ListIterator<Songs> listmins = AlbumTracks.listIterator();
        printActions();

        if(AlbumTracks.isEmpty()) {
            System.out.println("No songs within the playlist.");
            return;
        } else {
            System.out.println("Now playing " + listIteratorz.next().getSongName());
        }

        // Inside playlist functions

        while (!quit) {
            int action = 0;

            try {
                action = Integer.parseInt(userinput.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }

            switch (action) {
                case 0:
                    printActions();
                    break;
                case 1:
                    //nextSong();
                    if (!goingForward) {
                        if(listIteratorz.hasNext()) {
                            listIteratorz.next();
                        }
                        goingForward = true;
                    }
                    if(listIteratorz.hasNext()) {
                        System.out.println("Now playing " + listIteratorz.next().getSongName());
                    } else {
                        System.out.println("End of playlist.");
                        goingForward = false;
                    }
                    break;
                case 2:
//                    previousSong();
                    if (goingForward) {
                        if(listIteratorz.hasPrevious()) {
                            listIteratorz.previous();
                        }
                        goingForward = false;
                    }
                    if(listIteratorz.hasPrevious()) {
                        System.out.println("Now playing " + listIteratorz.previous().getSongName());
                    } else {
                        System.out.println("Start of playlist.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    // Replay song
                    if(listIteratorz.hasPrevious()){
                    System.out.println("Now playing " + listIteratorz.previous().getSongName());
                    listIteratorz.next();
                    } else {
                        System.out.println("Beginning of playlist.");
                    }
                    break;
                case 4:
                    // Remove Track
                    if(listIteratorz.hasPrevious() && listIteratorz.hasNext()) {
                        listIteratorz.remove();
                            System.out.println("Moved on to next.");
                            System.out.println("Now playing: " + listIteratorz.next().getSongName());
                    }
                    else if(listIteratorz.hasPrevious() || listIteratorz.hasNext()) {
                        listIteratorz.remove();
                        if (listIteratorz.hasPrevious()) {
                            System.out.println("Moved on to previous.");
                            System.out.println("Now playing: " + listIteratorz.previous().getSongName());
                        }
                        if (listIteratorz.hasNext()) {
                            System.out.println("Moved on to next.");
                            System.out.println("Now playing: " + listIteratorz.next().getSongName());
                        }
                    }
                    else {
                        System.out.println("No songs in your playlist.");
                    }
                    break;
                case 5:
                    System.out.println("Returning to musicplayer");
                    quit = true;
                    break;
            }

        }

    }

    private void printActions() {
        System.out.println("0 - Instructions" +
                "\n1 - Next song" +
                "\n2 - Previous song" +
                "\n3 - Replay song" +
                "\n4 - Remove from playlist" +
                "\n5 - Return to music player");
    }

}
