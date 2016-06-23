package com.company;

import java.util.Iterator;
import java.util.List;

/**
 * Created by omni on 6/2/16.
 */
public class Game {

    private List<Player> players;
    private Deck deck;
    private int currentRound = 0;

    public Game(List<Player> players) {
        this.players = players;
        //Get a deck of cards

        deck = Deck.createStandardDeck();
    }

    public RoundWinner war(Player player1, Player player2, Deck roundHand){
        List<Card> player1cards = player1.dealWar();
        List<Card> player2cards = player2.dealWar();


        Card player1up = player1cards.get(player1cards.size() - 1);
        Card player2up = player2cards.get(player2cards.size() - 1);

        RoundWinner winner = null;

        if(player1up.getRank().getRank() <= player2up.getRank().getRank()){
            winner = new RoundWinner(player1up, player1);
        }
        else{
            winner = new RoundWinner(player2up, player2);
        }

        roundHand.addCards(player1cards);
        roundHand.addCards(player2cards);

        return winner;

    }

    public void nextRound(){
        currentRound++;

        System.out.format("*********Round %d starting*************\n", currentRound);

        Deck roundHand = new Deck();
        RoundWinner winner = null;
        for(Player player : players){
            Card card = player.flipCard();
            System.out.format("%s plays %s\n", player.getName(), card);

            roundHand.addCard(card);
            if(winner == null || winner.getCard().getRank().getRank() < card.getRank().getRank()){
                winner = new RoundWinner(card, player);
            }
            else if(winner.getCard().getRank().getRank() == card.getRank().getRank()){ //war
                winner = war(winner.getPlayer(), player, roundHand);
            }
        }

        winner.getPlayer().addWinningCards(roundHand.getCards());
        System.out.format("%s won this round with %s\n", winner.getPlayer().getName(), winner.getCard());
    }

    public void dealCards(){
        Iterator<Player> playerIterator = players.iterator();
        for(Card card : deck.getCards()){
            if(!playerIterator.hasNext()){
                playerIterator = players.iterator();
            }

            playerIterator.next().takeCard(card);
        }
    }

    public void playersOut(){
        Iterator<Player> iter = players.iterator();

        while(iter.hasNext()){
            Player player = iter.next();
            if(!player.hasCards()) {
                iter.remove();
            }
        }
    }

    public Player winner(){
        Player winner = null;
        if(players.size() == 1){
            winner = players.get(0);
        }

        return winner;
    }

    public void runGame(){
        System.out.println("Lets play WAR.  Players set and it is time");

        dealCards();

        while(winner() == null) {
            nextRound();
            playersOut();
        }

        System.out.format("%s wins!!!!\n", winner().getName());

    }

}
