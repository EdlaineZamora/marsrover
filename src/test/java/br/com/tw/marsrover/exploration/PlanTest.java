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

public class PlanTest {

    @Test
    public void createsHigherPositionFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createDefaultInputExplorationPlan();
        Position expectedPosition = new Position(inputLines.get(0));

        Plan plan = new Plan(inputLines);

        assertEquals(expectedPosition, plan.higherPosition());
    }

    @Test
    public void createsOneRoverFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createDefaultInputExplorationPlan();
        Position initialPosition = new Position(inputLines.get(1));

        Rover expectedRover = new Rover(initialPosition, CardinalPoint.N, "RM");

        Plan plan = new Plan(inputLines);

        assertEquals(expectedRover, plan.rovers().get(0));
    }

    @Test
    public void moveOneRoverToRM() throws Exception {
        List<Rover> expectedRovers = singletonList(new Rover(new Position("1 0"), CardinalPoint.L, ""));

        List<String> inputExplorationPlan = createDefaultInputExplorationPlan();
        Plan plan = new Plan(inputExplorationPlan);

        List<Rover> rovers = plan.explore();

        assertEquals(expectedRovers, rovers);
    }

    private List<String> createDefaultInputExplorationPlan() {
        List<String> inputLines = new ArrayList<>();
        inputLines.add("2 2");
        inputLines.add("0 0 N");
        inputLines.add("RM");
        return inputLines;
    }

}