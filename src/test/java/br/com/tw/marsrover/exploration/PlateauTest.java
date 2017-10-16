package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.exploration.rover.CardinalPoint;
import br.com.tw.marsrover.exploration.rover.Moviment;
import br.com.tw.marsrover.exploration.rover.Rover;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class PlateauTest {

    @Test
    public void createsOneRoverFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createInputExplorationPlan("RM", "0 0 N", "2 2");
        Position initialPosition = new Position(inputLines.get(1));

        Rover expectedRover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList(new Moviment("RM")));

        Plateau plateau = new Plateau(inputLines);

        assertEquals(expectedRover, plateau.rovers().get(0));
    }

    @Test
    public void moveOneRoverToRM() throws Exception {
        List<Rover> expectedRovers = singletonList(new Rover(new Position("1 0"), CardinalPoint.E, Collections.emptyList()));

        List<String> inputExplorationPlan = createInputExplorationPlan("RM", "0 0 N", "2 2");
        Plateau plateau = new Plateau(inputExplorationPlan);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    @Test
    public void moveOneRoverToLM() throws Exception {
        List<Rover> expectedRovers = singletonList(new Rover(new Position("0 0"), CardinalPoint.W, Collections.emptyList()));

        List<String> inputExplorationPlan = createInputExplorationPlan("LM", "1 0 N", "2 2");
        Plateau plateau = new Plateau(inputExplorationPlan);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    @Test
    public void exploresOneRoverToLM() throws Exception {
        List<Rover> expectedRovers = singletonList(new Rover(new Position("1 3"), CardinalPoint.N, Collections.emptyList()));

        List<String> inputExplorationPlan = createInputExplorationPlan("LMLMLMLMM", "1 2 N", "5 5");
        Plateau plateau = new Plateau(inputExplorationPlan);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    @Test
    public void exploresTwoRoversWithSomeMoves() throws Exception {
        Rover firstExpectedRover = new Rover(new Position("1 3"), CardinalPoint.N, Collections.emptyList());
        Rover secondExpectedRover = new Rover(new Position("5 1"), CardinalPoint.E, Collections.emptyList());
        List<Rover> expectedRovers = Arrays.asList(firstExpectedRover, secondExpectedRover);

        List<String> inputLines = new ArrayList<>();
        inputLines.add("5 5");
        inputLines.add("1 2 N");
        inputLines.add("LMLMLMLMM");
        inputLines.add("3 3 E");
        inputLines.add("MMRMMRMRRM");

        Plateau plateau = new Plateau(inputLines);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    @Test
    public void exploresOneRoversWithSomeMoves() throws Exception {
        Rover secondExpectedRover = new Rover(new Position("5 1"), CardinalPoint.E, Collections.emptyList());
        List<Rover> expectedRovers = Arrays.asList(secondExpectedRover);

        List<String> inputLines = new ArrayList<>();
        inputLines.add("5 5");
        inputLines.add("3 3 E");
        inputLines.add("MMRMMRMRRM");

        Plateau plateau = new Plateau(inputLines);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    private List<String> createInputExplorationPlan(String moviments, String position, String plateauSize) {
        List<String> inputLines = new ArrayList<>();
        inputLines.add(plateauSize);
        inputLines.add(position);
        inputLines.add(moviments);
        return inputLines;
    }

}