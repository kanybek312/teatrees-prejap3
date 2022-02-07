package com.epam.prejap.teatrees;

/**
 * To score the game
 * @see com.epam.prejap.teatrees.game.Playfield
 */
public class Score {

    private int points;
    public Score(int points) {
        this.points = points;
    }
    /**
     *
     * @return points
     */
    public int points() {
        return points;
    }
    /**
     * increase point
     *
     * @return increased score
     */
    public int increaseScore(){
        return ++points;
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
