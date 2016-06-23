package com.company;

/**
 * Created by omni on 6/2/16.
 */
public class RoundWinner {

    private Card card;
    private Player player;

    public RoundWinner(Card card, Player player) {
        this.card = card;
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public Player getPlayer() {
        return player;
    }
}
