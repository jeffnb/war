package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by omni on 6/2/16.
 */
public class Deck {
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void addCards(List<Card> cards){
        this.cards.addAll(cards);
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card dealCard(){
        return cards.remove(0);
    }

    public boolean hasNext(){
        return cards.size() > 0;
    }

    public int cardCount(){
        return cards.size();
    }

    public static Deck createStandardDeck(){
        Deck deck = new Deck();

        for( Suit suit : Suit.values()){
            for(Rank rank : Rank.values()) {
                deck.addCard(new Card(suit, rank));
            }
        }

        deck.shuffle();
        return deck;
    }
}
