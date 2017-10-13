package br.com.tw.marsrover.rover;

import br.com.tw.marsrover.exploration.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest {

    @Test
    public void createsRoverWithInitialPositionAndOneMoviment() throws Exception {
        Position initialPosition = new Position("0 0");

        Rover rover = new Rover(initialPosition, "N", "RM");

        assertEquals(initialPosition, rover.initialPosition());
    }

}