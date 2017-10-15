package br.com.tw.marsrover.exploration.rover;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovimentTest {

    @Test
    public void createsMovimentWithLeftDirection() throws Exception {
        Moviment moviment = new Moviment("LM");

        assertEquals("L", moviment.direction());
    }

    @Test
    public void createsMovimentWithOneMove() throws Exception {
        Moviment moviment = new Moviment("LM");

        assertEquals(1, moviment.quantity());
    }

    @Test
    public void createsMovimentWithTwoMove() throws Exception {
        Moviment moviment = new Moviment("LMM");

        assertEquals(2, moviment.quantity());
    }

}