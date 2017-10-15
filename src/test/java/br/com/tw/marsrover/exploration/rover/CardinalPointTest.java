package br.com.tw.marsrover.exploration.rover;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class CardinalPointTest {

    @Test
    public void nextCardinalPointIsLWhenActualIsNAndThereIsOneMovimentToRight() throws Exception {
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(new Moviment("RM")));

        assertEquals(CardinalPoint.E, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsOWhenActualIsNAndThereIsOneMovimentToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment));

        assertEquals(CardinalPoint.W, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsSWhenActualIsNAndThereAreTwoMovimentsToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment, moviment));

        assertEquals(CardinalPoint.S, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsLWhenActualIsNAndThereAreThreeMovimentsToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment, moviment, moviment));

        assertEquals(CardinalPoint.E, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsNWhenActualIsNAndThereAreFourMovimentsToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment, moviment, moviment, moviment));

        assertEquals(CardinalPoint.N, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsSWhenActualIsNAndThereIsTwoMovimentToRight() throws Exception {
        Moviment moviment = new Moviment("RM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment, moviment));

        assertEquals(CardinalPoint.S, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsOWhenActualIsNAndThereIsThreeMovimentToRight() throws Exception {
        Moviment moviment = new Moviment("RM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment, moviment, moviment));

        assertEquals(CardinalPoint.W, cardinalPoint);
    }

    @Test
    public void nextCardinalPointIsNWhenActualIsNAndThereIsFourMovimentToRight() throws Exception {
        Moviment moviment = new Moviment("RM");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(CardinalPoint.N, asList(moviment, moviment, moviment, moviment));

        assertEquals(CardinalPoint.N, cardinalPoint);
    }


}