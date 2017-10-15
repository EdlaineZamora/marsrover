package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.exploration.rover.CardinalPoint;
import br.com.tw.marsrover.exploration.rover.Rover;
import br.com.tw.marsrover.exploration.rover.RoverCollection;
import org.junit.Test;

import javax.smartcardio.Card;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RoverCollectionTest {

    @Test
    public void createsRoverCollectionsToOneRoverAndOneMoviment() throws Exception {
        Position initialPosition = new Position("0 0");

        Rover expectedRover = new Rover(initialPosition, CardinalPoint.N, "RM");
        List<String> inputForOneRoverAndOneMoviment = asList("0 0 N", "RM");

        RoverCollection roverCollection = new RoverCollection(inputForOneRoverAndOneMoviment);

        assertEquals(expectedRover, roverCollection.rovers().get(0));
    }

    @Test
    public void createsRoverCollectionsWithTwoRovers() throws Exception {
        Position initialPosition = new Position("0 0");

        Rover expectedFirstRover = new Rover(initialPosition, CardinalPoint.N, "RM");
        Rover expectedSecondRover = new Rover(initialPosition, CardinalPoint.S, "RM");

        List<String> inputForTwoRoversAndOneMovimentForEach = asList("0 0 N", "RM", "0 0 S", "RM");

        RoverCollection roverCollection = new RoverCollection(inputForTwoRoversAndOneMovimentForEach);

        assertEquals(asList(expectedFirstRover, expectedSecondRover), roverCollection.rovers());
    }

    @Test
    public void movesRoverWithOneMovimentRM() throws Exception {
        Rover expectedRover = new Rover(new Position("1 0"), CardinalPoint.L, "");

        RoverCollection roverCollection = new RoverCollection(asList("0 0 N", "RM"));

        List<Rover> rovers = roverCollection.move();

        assertEquals(expectedRover, rovers.get(0));
    }

}