package com.epam.prejap.teatrees.game;

/**
 * To score the game.
 * @see com.epam.prejap.teatrees.game.Playfield
 */
class Score {

    private int points;
    public Score(int points) {
        this.points = points;
    }
    /**
     * With this method gets points.
     * @return points as int.
     */
    public int points() {
        return points;
    }
    /**
     * It increases points.
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
