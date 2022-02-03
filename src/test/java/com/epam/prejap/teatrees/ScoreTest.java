package com.epam.prejap.teatrees;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

import static org.testng.Assert.*;

@Test
public class ScoreTest {
    Score score = new Score(0);
    @Test
    public void testIncreaseScore() {
        // given
        int  move = 10;
        //when
        for (int i = 0; i < 10; i++) {
            score.increaseScore();
        }
        int point = score.points();
        //then
        Assert.assertEquals(move,point);
    }
}