package br.com.tw.marsrover.rover;

import br.com.tw.marsrover.exploration.Position;
import br.com.tw.marsrover.exploration.rover.CardinalPoint;
import br.com.tw.marsrover.exploration.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {

    private Position initialPosition;

    @Before
    public void setUp() throws Exception {
        initialPosition = new Position("0 0");
    }

    @Test
    public void createsRoverWithInitialPosition00() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, "RM");

        assertEquals(initialPosition, rover.initialPosition());
    }

    @Test
    public void createsRoverWithInitialCardinalPointN() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, "RM");

        assertEquals(CardinalPoint.N, rover.cardinalPoint());
    }

    @Test
    public void createsRoverWithMovimentsRM() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, "RM");

        assertEquals("RM", rover.moviments());
    }

    @Test
    public void movesRoverWithMovimentRM() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, "RM");
        Rover expectedRover = new Rover(new Position("1 0"), CardinalPoint.L, "");

        assertEquals(expectedRover, rover.move());
    }

}