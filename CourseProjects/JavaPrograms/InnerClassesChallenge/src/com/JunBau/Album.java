package com.JunBau;

import java.util.*;

public class Album {

    private String AlbumName;
    private SongList AlbumTracks;

    private Album(String albumName) {
        this.AlbumName = albumName;
        this.AlbumTracks = new SongList();
    }

    public static Album addAlbum (String name) {
        return new Album(name);
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public int getSongDuration (String searchName) {
        return AlbumTracks.albumTrack.get(findTrack(searchName)).getSongDuration();
    }


    // Track interactions

    public void AddTrack (String TrackName, int duration) {
        AlbumTracks.albumTrack.add(Song.addSong(TrackName,duration));
    }

    public void PrintTrackList () {
        Iterator<Song> i = AlbumTracks.albumTrack.iterator();
        Iterator<Song> o = AlbumTracks.albumTrack.iterator();
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

        for (int i = 0; i < AlbumTracks.albumTrack.size(); i++) {
            Song track = AlbumTracks.albumTrack.get(i);
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

        ListIterator<Song> listIteratorz = AlbumTracks.albumTrack.listIterator();
        ListIterator<Song> listmins = AlbumTracks.albumTrack.listIterator();
        printActions();

        if(AlbumTracks.albumTrack.isEmpty()) {
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

    private class SongList {

        private ArrayList<Song> albumTrack;

        public SongList () {
            this.albumTrack = new ArrayList<Song>();
        }

    }

}
