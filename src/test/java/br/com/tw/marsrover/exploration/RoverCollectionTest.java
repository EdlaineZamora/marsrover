package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.exploration.rover.CardinalPoint;
import br.com.tw.marsrover.exploration.rover.Moviment;
import br.com.tw.marsrover.exploration.rover.Rover;
import br.com.tw.marsrover.exploration.rover.RoverCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RoverCollectionTest {

    private Moviment oneMovimentToRight;
    private Moviment oneMovimentToLeft;

    @Before
    public void setUp() throws Exception {
        oneMovimentToRight = new Moviment("RM");
        oneMovimentToLeft = new Moviment("LM");
    }

    @Test
    public void createsRoverCollectionsToOneRoverAndOneMoviment() throws Exception {
        Position initialPosition = new Position("0 0");

        Rover expectedRover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList(oneMovimentToRight));
        List<String> inputForOneRoverAndOneMoviment = asList("0 0 N", "RM");

        RoverCollection roverCollection = new RoverCollection(inputForOneRoverAndOneMoviment);

        assertEquals(expectedRover, roverCollection.roversCopy().get(0));
    }

    @Test
    public void createsRoverCollectionsToOneRoverAndTwoMoviments() throws Exception {
        Position initialPosition = new Position("0 0");

        Rover expectedRover = new Rover(initialPosition, CardinalPoint.N, asList(oneMovimentToRight, oneMovimentToLeft));
        List<String> inputForOneRoverAndTwoMoviments = asList("0 0 N", "RMLM");

        RoverCollection roverCollection = new RoverCollection(inputForOneRoverAndTwoMoviments);

        assertEquals(expectedRover, roverCollection.roversCopy().get(0));
    }

    @Test
    public void createsRoverCollectionsWithTwoRovers() throws Exception {
        Position initialPosition = new Position("0 0");

        Rover expectedFirstRover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList(oneMovimentToRight));
        Rover expectedSecondRover = new Rover(initialPosition, CardinalPoint.S, Arrays.asList(oneMovimentToRight));

        List<String> inputForTwoRoversAndOneMovimentForEach = asList("0 0 N", "RM", "0 0 S", "RM");

        RoverCollection roverCollection = new RoverCollection(inputForTwoRoversAndOneMovimentForEach);

        assertEquals(asList(expectedFirstRover, expectedSecondRover), roverCollection.roversCopy());
    }

    @Test
    public void movesRoverWithOneMovimentRM() throws Exception {
        Rover expectedRover = new Rover(new Position("1 0"), CardinalPoint.E, Collections.emptyList());

        RoverCollection roverCollection = new RoverCollection(asList("0 0 N", "RM"));

        List<Rover> rovers = roverCollection.move();

        assertEquals(expectedRover, rovers.get(0));
    }

    @Test
    public void movesRoverWithOneMovimentLM() throws Exception {
        Rover expectedRover = new Rover(new Position("0 0"), CardinalPoint.W, Collections.emptyList());

        RoverCollection roverCollection = new RoverCollection(asList("1 0 N", "LM"));

        List<Rover> rovers = roverCollection.move();

        assertEquals(expectedRover, rovers.get(0));
    }

}