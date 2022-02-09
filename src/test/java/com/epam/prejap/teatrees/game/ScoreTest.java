package com.epam.prejap.teatrees;

import com.epam.prejap.teatrees.game.Printer;
import org.testng.*;
import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;


/**
 * Print string to this class
 * tpo check if there is anything or score appears int
 * collect output of application single string
 *
 * **/

@Test
public class ScoreTest {
    private Score score;
    private Printer printer;
    private ByteArrayOutputStream actual;

    @BeforeMethod

    public void setUp() {
        score = new Score(0);
        printer = printer = new Printer(new PrintStream(actual, true));
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
        assertTrue(move == point);
    }
    public void testPrintScore(){
        // given
        System.setOut(System.out);
        String  move = "56";
        System.out.println(printer);
        //when
        for (int i = 0; i < 56; i++) {
            score.increaseScore();
        }
        String point = score.toString();
        //then
        Assert.assertEquals(move, point);
    }
}
