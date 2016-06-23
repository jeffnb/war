package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omni on 6/2/16.
 */
public class Player {

    private Deck hand = new Deck();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public Card flipCard(){
        return hand.dealCard();
    }

    public void addWinningCards(List<Card> cards){
        hand.addCards(cards);
    }

    public String getName() {
        return name;
    }

    public void takeCard(Card card){
        hand.addCard(card);
    }

    public boolean hasCards(){
        return hand.hasNext();
    }

    public int cardsLeft(){
        return hand.cardCount();
    }

    public List<Card> dealWar(){
        List<Card> cards = new ArrayList<>();

        if(cardsLeft() >= 5) {
            for (int i = 0; i < 5; i++) {
                cards.add(hand.dealCard());
            }
        }
        else{
            cards = hand.getCards();
        }

        return cards;
    }
}
