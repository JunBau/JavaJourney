package com.JunBau;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

public class blackJackF {

    //Here will contain all the functions of the game. Created in a class so I can make certain functions private.
    //Also I'm aiming for an up to 4 player game - I believe I can do this with an array list.

    private ArrayList<playerOne> players = new ArrayList<playerOne>();
    private static Scanner userInput = new Scanner(System.in);
    private static ArrayList<String> cardSuitArray = new ArrayList<String>();

    public blackJackF () {
        // don't know what to put here tbh...
    }

    // Dealing functions. -----------------------------------------

    public void drawCard (String playerName, playerOne dealingCard) {
        players.get(findPlayer(playerName)).drawCard(dealingCard);
    }

    // Player functions. -----------------------------------------

    private boolean playerExists(String name) {
        int position = findPlayer(name);
        if(position >= 0) {
            return true;
        }
        return false;
    }

    private int findPlayer(String name) {
        for(int i = 0; i < this.players.size(); i++) {
            playerOne playerI = players.get(i);

            if(playerI.getPlayerName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int getplayerCurrency(String playerName) {
        return players.get(findPlayer(playerName)).getPlayerCurrency();
    }

    private void setplayerCurrency(String playerName, int amount) {
        players.get(findPlayer(playerName)).setPlayerCurrency(amount);
    }

    private void cardValues(String playerName) {
        System.out.print((players.get(findPlayer(playerName)).cardValues()));
    }

    private int cardActualValue(String playerName) {
        return players.get(findPlayer(playerName)).cardValues();
    }

    public cards getCard (String playerName, int i) {
        return players.get(findPlayer(playerName)).getCard(i);
    }

    // Player creation. ------------------------------------------

    public void addPlayer(String playerName) {
        if(!playerExists(playerName)) {
            players.add(playerOne.addPlayer(playerName));
            System.out.println(playerName + " has joined the game.");
        } else
        System.out.println("Player already exists.");
    }

    // Deck interactions... --------------------------------------

    public void destructHand(String playerName, playerOne movingBack) {
        players.get(findPlayer(playerName)).returningCardsToDeck(movingBack);
    }

    public String displayLastCard(String playerName) {
        return players.get(findPlayer(playerName)).displayLastCard();
    }

    // Making this private... what if someone created a deck and input which ever values they want? NOT HAPPENING.
    private void createFullDeck(String playerName) {
        players.get(findPlayer(playerName)).createDeck();
        System.out.println("Deck created for " + playerName);
    }

    public void shuffledDeck(String playerName) {
        players.get(findPlayer(playerName)).shuffledDeck();
        players.get(findPlayer(playerName)).shuffledDeck();
        System.out.println("Shuffled " + playerName + "s" + " deck.");
    }

    // Testing and validation ------------------------------------

    //Checking
    public void printCardList(String name) {
        System.out.println(players.get(findPlayer(name)).toStrings());
    }

    public void printPlayerList() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getPlayerName());
        }
    }

    // Does a deck create successfully?
    public void createDeck(String playerName) {
        createFullDeck(playerName);
    }

    // Testing another way of doing this.
    public void onePlayer(){
        cardSuites();
        System.out.println("Please enter player name: ");

        // Creating the players and the deck.
        // Players are stored in arrays, hoping to implement a local multi-player feature...
        String playerName = userInput.next();
        playerOne dealingDeck = new playerOne("Deck");

        // Dealing deck is directly instantiated from the playerOne class, it doesn't need to have certain functions.
        // Just needs to do it's thing being a deck tbh.
        dealingDeck.createDeck();
        String dealer = "CrackCocaine";

        // Adding the shuffled cards players will pull from.
        dealingDeck.shuffledDeck();

        // Adding the player with 0 cards.
        addPlayer(playerName);
        // Adding the dealer with 0 cards.
        addPlayer(dealer);

        setplayerCurrency(playerName, 50);
        int currentCurrency = getplayerCurrency(playerName);
        int playerBet = 0;

        while(currentCurrency > 0) {
            // Placing bet.
            System.out.println("\nYou have " + currentCurrency + " caps");
            System.out.println("Place a bet: ");

            try {
                playerBet = userInput.nextInt();
            } catch(Exception invalidBet) {
                System.out.println(dealer + ": The fuck is this shit? You trying to mock me?");
                userInput.next();
                break;
            }

            boolean endRound = false;

            if(playerBet > currentCurrency) {
                System.out.println(dealer + ": Are you trying to pull a fast one?");
                break;
            }

            try {
                System.out.println("Dealing cards...");
                for (int i = 0; i < cardSuitArray.size(); i ++) {
                    Thread.sleep(200);
                    System.out.print(cardSuitArray.get(i) + " ");
                    Thread.sleep(300);
                }
            } catch (Exception dealCard) {

            }

            System.out.print("\n\n");
            // Start dealing.
            // Player gets 2.
            drawCard(playerName,dealingDeck);
            drawCard(playerName,dealingDeck);

            // Dealer gets 2.
            drawCard(dealer,dealingDeck);
            drawCard(dealer,dealingDeck);

            while (true) {
                // Displaying player cards
                System.out.println("You have: ");
                printCardList(playerName);

                // Display value
                System.out.println("YOUR Total: ");
                cardValues(playerName);

                // Display dealer cards
                System.out.println("\n\n" + dealer + "s hand: " + getCard(dealer, 0).toStrings()
                        + " and [HIDDEN] ");

                // Player action Hit me? Stand?
                System.out.println("\nChoose an option: ");
                System.out.println("1. Hit" +
                        "\n2. Stand");

                int response = 0;

                try {
                    response = userInput.nextInt();
                } catch (Exception invNum) {
                    System.out.println("Invalid, please enter a number. \n");
                    userInput.next();
                }

                if (response == 1) {
                    drawCard(playerName, dealingDeck);
                    try {
                        System.out.println("You drew " + displayLastCard(playerName) + "\n");
                        Thread.sleep(500);
                    } catch (Exception f) {

                    }
                    // Lose going over 21
                    if(cardActualValue(playerName) > 21) {
                        System.out.println("BAM!, You've lost to the wasteland. Your hand was: "
                                + cardActualValue(playerName) + " in total.");
                        currentCurrency -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                //Stand
                if(response == 2) {
                    break;
                }

                if (response == 0) {
                    try {
                        System.out.println("Are you invalid?");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(200);
                            System.out.print(". ");
                            Thread.sleep(200);
                        }
                    } catch (Exception zeroIsInvalid) {

                    }
                    System.out.print("\n");
                }

                else if (response > 2 || response < 0) {
                    try {
                    System.out.println(response + " is not on the menu... rad poisoning got your eyesight?\n");
                    Thread.sleep(1000);
                    }
                    catch (Exception radPoisoning) {
                        userInput.next();
                    }
                }

            }

            // Revealing dealer cards:
            System.out.println("\n" + dealer + "s hand: ");
            printCardList(dealer);

            // Points vs CPU vs players
            if(cardActualValue(dealer) > cardActualValue(playerName) && endRound == false) {
                System.out.println(dealer + " has won." +
                        "\n" + cardActualValue(dealer) + " to " + cardActualValue(playerName));
                currentCurrency -= playerBet;
                endRound = true;
            }

            // Dealer hits at 16 stands at 17 (will probably change this) Update: Probably will use a random feature for the CPU to take a chance.
            while(cardActualValue(dealer) < 17 && endRound == false) {
                drawCard(dealer, dealingDeck);
                try {
                    System.out.println(dealer + " draws: " + displayLastCard(dealer));
                    Thread.sleep(400);
                } catch (Exception dealerDraws) {
                    // Again, not too sure what to put here...
                }
            }

            // Total for dealer
            System.out.println(dealer + "s hand value is: " + cardActualValue(dealer));

            // If the dealer busts... LOL
            if(cardActualValue(dealer) > 21 && endRound == false) {
                System.out.println(dealer + " went bust, your win!");
                currentCurrency += playerBet;
                endRound = true;
            }

            // This concludes a draw game.
            if(cardActualValue(dealer) == cardActualValue(playerName) && endRound == false) {
                System.out.println("Draw.");
                endRound = true;
            }

            // WINNING!

            if(cardActualValue(playerName) > cardActualValue(dealer) && endRound == false) {
                System.out.println(dealer + ": Take your damn caps! ");
                currentCurrency += playerBet;
                endRound = true;
            }

            // you've lost to the wasteland.

            else if(endRound == false) {
                System.out.println(dealer + ": better luck next time kid.");
                System.out.println("Dealer has won.");
                currentCurrency -= playerBet;
            }

            // End of hand. All cards back in.
            destructHand(playerName, dealingDeck);
            destructHand(dealer, dealingDeck);
            System.out.println("End of hand.");

        }

        // GAMEEEEE OVEERRRRRRR YERRRHHHHH
        System.out.println("You've been shot in the head. War... War never changes.\n");
        for (int i = 0; i < players.size(); i = 0) {
            System.out.println(players.get(i).getPlayerName() + " has blown up");
            players.remove(i);
        }

        for (int i = 0; i < cardSuitArray.size(); i = 0) {
            cardSuitArray.remove(i);
        }

        try {
            System.out.println("\nLet's do something annoying when you lose :)");
            Desktop desktop = java.awt.Desktop.getDesktop();
            Thread.sleep(2500);
            URI oURL = new URI("https://www.youtube.com/watch?v=VkC63ReV5Jk");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void cardSuites() {
        cardSuitArray.add("\u2660");
        cardSuitArray.add("\u2666");
        cardSuitArray.add("\u2663");
        cardSuitArray.add("\u2764");
    }
}
