package com.epam.prejap.teatrees;

public class Score {

    private int points;
    public Score(int points) {
        this.points = points;
    }

    public int points() {
        return points;
    }

    public int increaseScore(){
        return ++points;
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
