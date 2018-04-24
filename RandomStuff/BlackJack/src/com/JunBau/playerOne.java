package com.JunBau;

import java.util.ArrayList;
import java.util.Random;

public class playerOne {

    private String playerName;
    private int playerCurrency;
    private ArrayList<cards> Cards;

    // Constructor

    public playerOne(String playerName) {
        this.playerName = playerName;
        this.playerCurrency = playerCurrency;
        this.Cards = new ArrayList<cards>();
    }

    // player interactions


    public void setPlayerCurrency(int playerCurrency) {
        this.playerCurrency = playerCurrency;
    }

    public int getPlayerCurrency() {
        return playerCurrency;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static playerOne addPlayer(String name) {
        return new playerOne(name);
    }

    public String displayLastCard() {
        return Cards.get(Cards.size()-1).toStrings();
    }

    // card actions
    // There should be 52 cards in a deck...
    public void createDeck() {

        // Loops through suits
        for(cardSuit suit : cardSuit.values()) {

            // Loops through card values
            for(cardValue values : cardValue.values()) {

                //Adds cards for player
                this.Cards.add(new cards(suit,values));
            }
        }
    }

    public void shuffledDeck() {
        shuffleDeck();
    }

    // Making the shuffle method private again, don't want this to be accessible outside this class.
    private void shuffleDeck() {
        ArrayList<cards> newDeck = new ArrayList<cards>();

        // Random to shuffle the cards.
        Random shuffle = new Random();

        int randomCardIndex = 0;
        int originalSize = this.Cards.size();

        for(int i = 0; i < originalSize; i++) {
            // Generates random index within the array list.
            randomCardIndex = shuffle.nextInt((this.Cards.size() -1 ) +1);
            // Adds the random card to the shuffled deck arraylist.
            newDeck.add(this.Cards.get(randomCardIndex));
            // Removes the card from the original deck
            this.Cards.remove(randomCardIndex);
        }
        // Replaces the default deck with the shuffled deck.
        this.Cards = newDeck;
    }

    // Removing card from deck
    private void removeCard(int i) {
        this.Cards.remove(i);
    }

    // Grabbing card from deck
    public cards getCard(int i) {
        return this.Cards.get(i);
    }

    private void addCard(cards addCard) {
        this.Cards.add(addCard);
    }

    // Drawing card from the deck.
    public void drawCard(playerOne dealingFrom) {
        //Add card to hand from the deck, getting the first card with getCard, Arrays start at 0!
        this.Cards.add(dealingFrom.getCard(0));
        //remove the same card from dealing deck. AGAIN, Arrays start at 0!
        dealingFrom.removeCard(0);
    }

    public void returningCardsToDeck(playerOne moveto) {
        int deckSize = this.Cards.size();
        // Putting the cards back in
        for (int i = 0; i < deckSize; i++) {
            moveto.addCard(this.getCard(i));
        }
        // Emptying current players hand
        for (int i = 0; i < deckSize; i++) {
            this.removeCard(0);
        }
    }

    // Test stuff like printing deck
    public String toStrings() {
        String cardOutput = "";
        int i = 0;
        for(cards iCard : this.Cards) {
            cardOutput += iCard.toStrings() + "\n";
            i++;
        }
//        System.out.println("Returning list " +
//                "\nindex starts at 0 for Arrays.");
        return cardOutput;
    }

    // Card values
    public int cardValues() {
        int totalValue = 0;
        int aces = 0;

        for(cards iCard : this.Cards) {
            // Switch for enum values.
            switch(iCard.getValue()) {
                case Two:
                    totalValue += 2;
                    break;
                case Three:
                    totalValue += 3;
                    break;
                case Four:
                    totalValue += 4;
                    break;
                case Five:
                    totalValue += 5;
                    break;
                case Six:
                    totalValue += 6;
                    break;
                case Seven:
                    totalValue += 7;
                    break;
                case Eight:
                    totalValue += 8;
                    break;
                case Nine:
                    totalValue += 9;
                    break;
                case Ten:
                    totalValue += 10;
                    break;
                case Jack:
                    totalValue += 10;
                    break;
                case Queen:
                    totalValue += 10;
                    break;
                case King:
                    totalValue += 10;
                    break;
                case Ace:
                    aces += 1;
            }
        }

        for(int i = 0; i < aces; i++){
            //If they're already at over 10 getting an ace valued at 11 would put them up to 22, so make ace worth one
            if (totalValue > 10){
                totalValue += 1;
            }
            else{
                totalValue += 11;
            }
        }
        // Returning the value.
        return totalValue;
    }

}
