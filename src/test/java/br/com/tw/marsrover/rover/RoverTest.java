package br.com.tw.marsrover.rover;

import br.com.tw.marsrover.exploration.Position;
import br.com.tw.marsrover.exploration.rover.CardinalPoint;
import br.com.tw.marsrover.exploration.rover.Moviment;
import br.com.tw.marsrover.exploration.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RoverTest {

    private Position initialPosition;
    private Moviment oneMovimentToRight;
    private Moviment oneMovimentToLeft;

    @Before
    public void setUp() throws Exception {
        initialPosition = new Position("0 0");
        oneMovimentToRight = new Moviment("RM");
        oneMovimentToLeft = new Moviment("LM");
    }

    @Test
    public void createsRoverWithInitialPosition00() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, asList(oneMovimentToRight));

        assertEquals(initialPosition, rover.initialPosition());
    }

    @Test
    public void createsRoverWithInitialCardinalPointN() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, asList(oneMovimentToRight));

        assertEquals(CardinalPoint.N, rover.cardinalPoint());
    }

    @Test
    public void createsRoverWithMovimentsRM() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, asList(oneMovimentToRight));

        Moviment expectedMoviment = new Moviment("RM");

        assertEquals(asList(expectedMoviment), rover.moviments());
    }

    @Test
    public void movesRoverWithMovimentRM() throws Exception {
        Rover rover = new Rover(initialPosition, CardinalPoint.N, asList(oneMovimentToRight));
        Rover expectedRover = new Rover(new Position("1 0"), CardinalPoint.L, Collections.emptyList());

        assertEquals(expectedRover, rover.move());
    }

    @Test
    public void movesRoverWithMovimentLM() throws Exception {
        Rover rover = new Rover(new Position("1 0"), CardinalPoint.N, asList(oneMovimentToLeft));
        Rover expectedRover = new Rover(new Position("0 0"), CardinalPoint.O, Collections.emptyList());

        assertEquals(expectedRover, rover.move());
    }

}