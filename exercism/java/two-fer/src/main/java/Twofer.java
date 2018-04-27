import java.util.Scanner;

class Twofer {

    Scanner userInput = new Scanner(System.in);

    String twofer(String name) {
        if (name == null)
            name = "you";
        return "One for " + name + ", one for me.";/*
        String sentence;
        if(name != null) {
            sentence = "One for " + name + ", one for me.";
        } else {
            sentence = "One for you, one for me.";
        }

        return sentence;*/

    }
}
