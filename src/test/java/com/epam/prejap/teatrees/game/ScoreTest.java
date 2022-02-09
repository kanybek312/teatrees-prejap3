package com.epam.prejap.teatrees.game;

import org.testng.*;
import org.testng.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static java.lang.System.*;
import static org.testng.Assert.*;


@Test
public class ScoreTest {
    private Score score;
    private ByteArrayOutputStream expected;
    private ByteArrayOutputStream actual;
    private Printer printer;

    @BeforeMethod
    public void setUp() {
        score = new Score(0);
        expected = new ByteArrayOutputStream();
        actual = new ByteArrayOutputStream();
        printer = new Printer(new PrintStream(actual, true));
        System.setOut(new PrintStream(expected, true));
    }
    @AfterMethod
    private void cleanup() {
        System.setOut(System.out);
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
        assertEquals(move, point);
    }
    public void testPrintScore(){
        // given

        int point = new Random().nextInt(100) - 1;

        //when
        for (int i = 0; i < point; i++) {
            score.increaseScore();
        }
        printer.printPoint(score);

        //then
        assertEquals(actual.toString(),"Your score: "+ point + lineSeparator());
    }
}
