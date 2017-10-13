package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.rover.Rover;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RoverCollectionTest {

    @Test
    public void createRoverCollectionsToOneRoverAndOneMoviment() throws Exception {
        Rover expectedRover = new Rover(new Position("0 0"), "N", "RM");
        List<String> inputForOneRoverAndOneMoviment = asList("0 0 N", "RM");

        RoverCollection roverCollection = new RoverCollection(inputForOneRoverAndOneMoviment);

        assertEquals(expectedRover, roverCollection.rovers().get(0));
    }

}