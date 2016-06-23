package com.company;

/**
 * Created by omni on 6/2/16.
 */
public enum Rank {
    Ace(14), King(13), Queen(12), Jack(11), Ten(10),
    Nine(9), Eight(8), Seven(7), Six(6), Five(5),
    Four(4), Three(3), Two(2);

    private int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }
}
