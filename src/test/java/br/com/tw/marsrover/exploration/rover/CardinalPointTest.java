package br.com.tw.marsrover.exploration.rover;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardinalPointTest {

    @Test
    public void nextCardinalPointIsLWhenActualIsNAndThereIsOneMovimentToRight() throws Exception {
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, new String[]{"R", "M"});

        assertEquals(CardinalPoint.L, cardinalPoint);
    }

}