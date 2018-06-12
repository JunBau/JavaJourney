package com.JunBau;

import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<T extends Team> {

    public String name;
    private ArrayList<T> competitor = new ArrayList<>();

    public LeagueTable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (competitor.contains(team)) {
            System.out.println(team.getName() + " is already in the league.");
            return false;
        } else {
            System.out.println(team.getName() + " has been added to " + this.name + " League.");
            competitor.add(team);
            return true;
        }
    }

    public void PrintTeams() {
        System.out.println(" ");
        for(int i = 0; i < competitor.size(); i++) {
            String player = competitor.get(i).getName();
            System.out.println(i+1 + ". "  + player + " with " + competitor.get(i).ranking() + " points.");
        } if (competitor.isEmpty()) {
            System.out.println("No teams in this league.");
        }
    }

    public void SortLeagueTable() {
        Collections.sort(competitor);
        for (T t : competitor) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }


}
