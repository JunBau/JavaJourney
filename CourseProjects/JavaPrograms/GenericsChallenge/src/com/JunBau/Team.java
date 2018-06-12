package com.JunBau;

import java.util.ArrayList;

public class Team<P extends Player> implements Comparable<Team<P>> {

    private String name;
    private int played = 0;
    private int won = 0;
    private int loss = 0;
    private int tied =0;

    private ArrayList<P> members = new ArrayList<>();

    @Override
    public int compareTo(Team<P> o) {
        if(this.ranking() > o.ranking()) {
            return -1;
        } else if (this.ranking() < o.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(P player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on the team.");
            return false;
        } else {
            System.out.println(player.getName() + " has been added to " + this.name + ".");
            members.add(player);
            return true;
        }
    }

    public int PlayerCount() {
        return this.members.size();
    }

    public void PrintPlayers() {
        System.out.println(" ");
        for(int i = 0; i < members.size(); i++) {
            String player = members.get(i).getName();
            System.out.println(i+1 + ". "  + player);
        } if (members.isEmpty()) {
            System.out.println("No players on this team.");
        }
    }

    public void MatchResult(Team<P> opponent, int teamScore, int theirScore) {

        String message;

        if (teamScore > theirScore) {
            ++won;
            message = " beat ";
        } else if (teamScore == theirScore) {
            ++tied;
            message = " drew with ";
        } else {
            ++loss;
            message = " lost against " ;
        }

        ++played;

        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.MatchResult(null, theirScore, teamScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

}
