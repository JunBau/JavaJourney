package com.JunBau;

class movie{
    private String name;

    public movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends movie {

    public Jaws(){
        super("Jaws");
    }

    public String plot() {
        return "Shark eats lots of people.";
    }
}

class IndependenceDay extends movie {

    public IndependenceDay(){
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens and shit.";
    }
}

class MazeRunner extends movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try escape maze.";
    }
}

class StarWars extends movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Blah blah blah Galaxy blah blah.";
    }
}

class Forgetable extends movie {
    public Forgetable() {
        super("Forgetable");
    }

    //No plot method.
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        for(int x = 1; x < 11; x++){
            movie Movie = randomMovie();
            System.out.println("Movie #" + x + " : " + Movie.getName() + "\n"
                    + "Plot: " + Movie.plot() + "\n");
        }

    }
    public static movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generator was: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();

            case 2:
                return new IndependenceDay();

            case 3:
                return new MazeRunner();

            case 4:
                return new StarWars();

            case 5:
                return new Forgetable();

                default:
                    return null;
        }
    }

}


