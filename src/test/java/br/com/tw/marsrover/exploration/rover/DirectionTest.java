package br.com.tw.marsrover.exploration.rover;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void nextCardinalPointIsLWhenActualIsNAndThereIsOneMovimentToRight() throws Exception {
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(new Moviment("RM")));

        assertEquals(Direction.E, direction);
    }

    @Test
    public void nextCardinalPointIsOWhenActualIsNAndThereIsOneMovimentToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(moviment));

        assertEquals(Direction.W, direction);
    }

    @Test
    public void nextCardinalPointIsSWhenActualIsNAndThereAreTwoMovimentsToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(moviment, moviment));

        assertEquals(Direction.S, direction);
    }

    @Test
    public void nextCardinalPointIsLWhenActualIsNAndThereAreThreeMovimentsToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(moviment, moviment, moviment));

        assertEquals(Direction.E, direction);
    }

    @Test
    public void nextCardinalPointIsNWhenActualIsNAndThereAreFourMovimentsToLeft() throws Exception {
        Moviment moviment = new Moviment("LM");
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(moviment, moviment, moviment, moviment));

        assertEquals(Direction.N, direction);
    }

    @Test
    public void nextCardinalPointIsSWhenActualIsNAndThereIsTwoMovimentToRight() throws Exception {
        Moviment moviment = new Moviment("RM");
        List<Moviment> commands = asList(moviment, moviment);
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, commands);

        assertEquals(Direction.S, direction);
    }

    @Test
    public void nextCardinalPointIsOWhenActualIsNAndThereIsThreeMovimentToRight() throws Exception {
        Moviment moviment = new Moviment("RM");
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(moviment, moviment, moviment));

        assertEquals(Direction.W, direction);
    }

    @Test
    public void nextCardinalPointIsNWhenActualIsNAndThereIsFourMovimentToRight() throws Exception {
        Moviment moviment = new Moviment("RM");
        Direction direction = Direction.finalCardinalPointAfterCommands(Direction.N, asList(moviment, moviment, moviment, moviment));

        assertEquals(Direction.N, direction);
    }


}