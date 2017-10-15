package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.exploration.rover.CardinalPoint;
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
    public void createsHigherPositionFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createDefaultInputExplorationPlan("RM", "0 0 N");
        Position expectedPosition = new Position(inputLines.get(0));

        Plateau plateau = new Plateau(inputLines);

        assertEquals(expectedPosition, plateau.higherPosition());
    }

    @Test
    public void createsOneRoverFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createDefaultInputExplorationPlan("RM", "0 0 N");
        Position initialPosition = new Position(inputLines.get(1));

        Rover expectedRover = new Rover(initialPosition, CardinalPoint.N, Arrays.asList("RM"));

        Plateau plateau = new Plateau(inputLines);

        assertEquals(expectedRover, plateau.rovers().get(0));
    }

    @Test
    public void moveOneRoverToRM() throws Exception {
        List<Rover> expectedRovers = singletonList(new Rover(new Position("1 0"), CardinalPoint.L, Collections.emptyList()));

        List<String> inputExplorationPlan = createDefaultInputExplorationPlan("RM", "0 0 N");
        Plateau plateau = new Plateau(inputExplorationPlan);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    @Test
    public void moveOneRoverToLM() throws Exception {
        List<Rover> expectedRovers = singletonList(new Rover(new Position("0 0"), CardinalPoint.O, Collections.emptyList()));

        List<String> inputExplorationPlan = createDefaultInputExplorationPlan("LM", "1 0 N");
        Plateau plateau = new Plateau(inputExplorationPlan);

        List<Rover> rovers = plateau.explore();

        assertEquals(expectedRovers, rovers);
    }

    private List<String> createDefaultInputExplorationPlan(String moviments, String position) {
        List<String> inputLines = new ArrayList<>();
        inputLines.add("2 2");
        inputLines.add(position);
        inputLines.add(moviments);
        return inputLines;
    }

}