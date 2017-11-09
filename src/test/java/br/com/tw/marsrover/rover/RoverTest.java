package br.com.tw.marsrover.rover;

import br.com.tw.marsrover.exploration.Position;
import br.com.tw.marsrover.exploration.rover.Direction;
import br.com.tw.marsrover.exploration.rover.Moviment;
import br.com.tw.marsrover.exploration.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

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
        Rover rover = new Rover(initialPosition, Direction.N, asList(oneMovimentToRight));

        assertEquals(initialPosition, rover.initialPosition());
    }

    @Test
    public void createsRoverWithInitialCardinalPointN() throws Exception {
        Rover rover = new Rover(initialPosition, Direction.N, asList(oneMovimentToRight));

        assertEquals(Direction.N, rover.cardinalPoint());
    }

    @Test
    public void createsRoverWithMovimentsRM() throws Exception {
        Rover rover = new Rover(initialPosition, Direction.N, asList(oneMovimentToRight));

        Moviment expectedMoviment = new Moviment("RM");

        assertEquals(asList(expectedMoviment), rover.moviments());
    }

    @Test
    public void whenRoverStartsAtPosition00NAndExecuteCommandsRMItFinishesAtPosition10E() throws Exception {
        Direction initialDirection = Direction.N;
        List<Moviment> commandsToExecute = asList(oneMovimentToRight);
        Rover rover = new Rover(initialPosition, initialDirection, commandsToExecute);

        Position position = new Position("1 0");
        Direction direction = Direction.E;
        List<Moviment> commands = Collections.emptyList();
        Rover expectedRover = new Rover(position, direction, commands);

        Rover movedRover = rover.move();

        assertEquals(expectedRover, movedRover);
    }

    @Test
    public void movesRoverWithMovimentLM() throws Exception {
        Rover rover = new Rover(new Position("1 0"), Direction.N, asList(oneMovimentToLeft));
        Rover expectedRover = new Rover(new Position("0 0"), Direction.W, Collections.emptyList());

        assertEquals(expectedRover, rover.move());
    }

}