package com.JunBau;

public class cards {

    private cardSuit suit;
    private cardValue value;

    public cards(cardSuit suit, cardValue value) {
        this.value = value;
        this.suit = suit;
    }

    public cardValue getValue() {
        return this.value;
    }

    public String toStrings() {
        return this.suit.toString() + " - " + this.value.toString();
    }

}
