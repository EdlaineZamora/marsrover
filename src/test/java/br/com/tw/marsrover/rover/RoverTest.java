package br.com.tw.marsrover.rover;

import br.com.tw.marsrover.exploration.Position;
import br.com.tw.marsrover.exploration.rover.CardinalPoint;
import br.com.tw.marsrover.exploration.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class RoverTest {

    private Position initialPosition;

    @Before
    public void setUp() throws Exception {
        initialPosition = new Position("0 0");
    }

    @Test
    public void createsRoverWithInitialPosition00() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList("RM"));

        assertEquals(initialPosition, rover.initialPosition());
    }

    @Test
    public void createsRoverWithInitialCardinalPointN() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList("RM"));

        assertEquals(CardinalPoint.N, rover.cardinalPoint());
    }

    @Test
    public void createsRoverWithMovimentsRM() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList("RM"));

        assertEquals(Arrays.asList("RM"), rover.moviments());
    }

    @Test
    public void movesRoverWithMovimentRM() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList("RM"));
        Rover expectedRover = new Rover(new Position("1 0"), CardinalPoint.L, Collections.emptyList());

        assertEquals(expectedRover, rover.move());
    }

    @Test
    public void movesRoverWithMovimentLM() throws Exception {
        Rover rover = new Rover(new Position("1 0"), CardinalPoint.N, Arrays.asList("LM"));
        Rover expectedRover = new Rover(new Position("0 0"), CardinalPoint.O, Collections.emptyList());

        assertEquals(expectedRover, rover.move());
    }

}