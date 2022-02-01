package com.epam.prejap.teatrees;

class Score {

    private int points;
    public Score(int points) {
        this.points = points;
    }

    int points() {
        return points;
    }

    int increaseScore(){
        return ++points;
    }

    @Override
    public String toString() {
        return points + "";
    }
}
