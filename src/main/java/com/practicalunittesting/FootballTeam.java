package com.practicalunittesting;

public class FootballTeam implements Comparable<FootballTeam>{
    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if(gamesWon < 0 ){
            throw new IllegalArgumentException("Games won should be greater than or equal to 0");
        }
        this.gamesWon = gamesWon;
    }

    @Override
    public int compareTo(FootballTeam otherTeam) {
        return gamesWon - otherTeam.getGamesWon();
    }

    public int getGamesWon() {
        return gamesWon;
    }
}
