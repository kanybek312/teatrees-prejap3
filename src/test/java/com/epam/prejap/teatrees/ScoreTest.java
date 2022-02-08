package com.epam.prejap.teatrees;

import com.epam.prejap.teatrees.game.Printer;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ScoreTest {
    private Score score;

    @BeforeMethod

    public void setUp() {
        score = new Score(0);
    }

    public void testIncreaseScore() {
        // given
        int  move = 10;
        //when
        for (int i = 0; i < move; i++) {
            score.increaseScore();
        }
        int point = score.points();
        //then
        Assert.assertTrue(move == point);
    }
    public void testPrintScore(){
        // given
        String  move = "56";

        //when
        for (int i = 0; i < 56; i++) {
            score.increaseScore();
        }
        String point = score.toString();
        //then
        Assert.assertEquals(move, point);
    }
}
