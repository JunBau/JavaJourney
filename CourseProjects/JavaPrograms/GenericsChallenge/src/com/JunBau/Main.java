package com.JunBau;

public class Main {

    public static void main(String[] args) {

        Team<FootballPlayer> calam = new FootballTeam("Calam");
        Team<FootballPlayer> colon = new FootballTeam("Colon");


        FootballPlayer joe = new FootballPlayer("Joe");
        FootballPlayer ben = new FootballPlayer("Ben");
        FootballPlayer tod = new FootballPlayer("Tod");

//        BaseballPlayer boo = new BaseballPlayer("boo");
//        calam.addPlayer(boo);

        calam.addPlayer(joe);
        calam.addPlayer(ben);
        calam.addPlayer(tod);

        calam.PrintPlayers();

        LeagueTable<Team<FootballPlayer>> champions = new LeagueTable<>("Champions");
        System.out.println(champions.getName() + " League.");
        champions.PrintTeams();

        champions.addTeam(calam);
        champions.addTeam(colon);
        champions.PrintTeams();

        calam.MatchResult(colon,3,5);

        champions.PrintTeams();

        champions.SortLeagueTable();

    }
}
