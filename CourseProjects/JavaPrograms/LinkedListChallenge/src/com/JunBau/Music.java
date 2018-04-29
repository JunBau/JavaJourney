package com.JunBau;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Music {

    private static Scanner userInput = new Scanner(System.in);
    private static String MusicAppVersion = "JunPlay v900";
    private static ArrayList<Albums> albums = new ArrayList<Albums>();

    // Music program.

    public static void MusicPlayer() {
        System.out.println("\n" + MusicAppVersion);
        System.out.println("Welcome to JunPlay!");
        boolean quit = false;
        int choice = 0;
        addDefaultPlaylist();
        printMenuList();

        while(!quit) {

            try {
                choice = Integer.parseInt(userInput.nextLine());
            } catch ( Exception choosingInt) {
                System.out.println("Invalid input");
            }

            switch (choice) {
                case 0:
                    printMenuList();
                    break;
                case 1:
                    addAlbum();
                    break;
                case 2:
                    printAlbumList();
                    break;
                case 3:
                    addSongToAlbum();
                    break;
                case 4:
                    printTrackList();
                    break;
                case 5:
                    playPlayList();
                    break;
                case 6:
                    System.out.println("Returning to mobile.");
                    quit = true;
                    break;
            }

        }

    }

    public static void printMenuList() {
        System.out.println("\nPlease choose an action:");
        System.out.println("0 - Functions");
        System.out.println("1 - Create a playlist");
        System.out.println("2 - Display all playlists");
        System.out.println("3 - Add song to playlist");
        System.out.println("4 - Display songs in an album or playlist");
        System.out.println("5 - Play playlist");
        System.out.println("6 - Dashboard");
    }

    // I could probably fix up the logic and make this look cleaner...

    public static void addSongToAlbum() {
        System.out.println("Please enter the source album: ");
        String albumName = userInput.nextLine();

        if(onFile(albumName)) {
            albums.get(findAlbum(albumName)).PrintTrackList();
            System.out.println("Please enter the song name to add: ");
            String songName = userInput.nextLine();

            if(trackOnFile(albumName,songName)) {
                System.out.println("please enter name of playlist to add to: ");
                String playlistDest = userInput.nextLine();

                if(onFile(playlistDest)) {
                    addSongToAlbum(playlistDest, songName, albums.get(findAlbum(albumName)).getSongDuration(songName));
                    System.out.println("Successfully added.");
                }

                if (!onFile(playlistDest)) {
                    System.out.println(playlistDest + " does not exist, would you like to create this? (Y/N)");
                    String response = userInput.nextLine().toLowerCase();
                    if(response.equals("y")) {
                        albums.add(Albums.addAlbum(playlistDest));
                        addSongToAlbum(playlistDest, songName, albums.get(findAlbum(albumName)).getSongDuration(songName));
                        System.out.println("Successfully added.");
                    }
                    else {
                        System.out.println("Returning to menu.");
                    }
                }

            }
            if (!trackOnFile(albumName,songName)) {
                System.out.println(songName + " does not exist");
            }
        } if(!onFile(albumName)) {
            System.out.println(albumName + " does not exist.");
        }
    }

    public static void playPlayList() {
        System.out.println("Please enter the album name: ");
        String albumName = userInput.nextLine();
        if (onFile(albumName)) {
            albums.get(findAlbum(albumName)).PlayTrackList();
        } else {
            System.out.println("Album or Playlist doesn't exist");
        }
    }

    // Constructs, getters, setters.

    public Music(String musicAppVersion, ArrayList<Albums> albums) {
        MusicAppVersion = musicAppVersion;
        this.albums = albums;
    }


    // Album background functions

    private static boolean trackOnFile (String albumNames, String songName) {
        return albums.get(findAlbum(albumNames)).onFile(songName);
    }

    private static boolean onFile (String searchName) {
        int position = findAlbum(searchName);

        if(position >= 0) {
            return true;
        }
        return false;
    }

    private static int findAlbum (String searchName) {
        for (int i = 0; i < albums.size(); i++) {
            Albums album = albums.get(i);

            if(album.getAlbumName().equals(searchName)) {
                return i;
            }
        }
        return -1;
    }

    // User Album interactions.

    private static void addAlbum() {
        System.out.println("Please enter the name of the album to add: ");
        String AlbumName = userInput.nextLine();
        if(!onFile(AlbumName)) {
            albums.add(Albums.addAlbum(AlbumName));
            System.out.println(AlbumName + " has been added successfully.");
        } else {
            System.out.println(AlbumName + " already exists.");
        }
    }

    private static void printAlbumList() {
        System.out.println("\nYou have the following in your library: ");
        for(int i = 0; i < albums.size(); i++) {
            System.out.println(albums.get(i).getAlbumName());
        }
    }

    private static void addSongToAlbum(String albumName, String songName, int duration) {
        albums.get(findAlbum(albumName)).AddTrack(songName, duration);
    }

    private static void printTrackList() {
        System.out.println("Enter the album name you would like to view track list: ");
        String albumName = userInput.nextLine();
        if (onFile(albumName)) {
            albums.get(findAlbum(albumName)).PrintTrackList();
        } else {
            System.out.println(albumName + " does not exist.");
        }
    }

    private static void addDefaultPlaylist() {
        albums.add(Albums.addAlbum("Java Master Class"));
        albums.get(findAlbum("Java Master Class")).AddTrack("Java is great!", 5);
        albums.get(findAlbum("Java Master Class")).AddTrack("Stack Over - FLOW", 4);
        albums.get(findAlbum("Java Master Class")).AddTrack("isLove Immutable?", 3);
        albums.get(findAlbum("Java Master Class")).AddTrack("Gorans interlude", 2);
        albums.get(findAlbum("Java Master Class")).AddTrack("Jivver Java", 5);
        albums.get(findAlbum("Java Master Class")).AddTrack("FINAL.", 2);

    }

}
