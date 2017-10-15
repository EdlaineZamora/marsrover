package br.com.tw.marsrover.exploration.rover;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CardinalPointTest {

    @Test
    public void nextCardinalPointIsLWhenActualIsNAndThereIsOneMovimentToRight() throws Exception {
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, Arrays.asList("RM"));

        assertEquals(CardinalPoint.L, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsOWhenActualIsNAndThereIsOneMovimentToLeft() throws Exception {
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, Arrays.asList("LM"));

        assertEquals(CardinalPoint.O, cardinalPoint);
    }

}