package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.exploration.rover.Rover;
import br.com.tw.marsrover.exploration.rover.RoverCollection;

import java.util.List;

public class Plan {

    private final Position higherPosition;
    private final RoverCollection rovers;

    public Plan(List<String> inputLines) {
        higherPosition = new Position(inputLines.get(0));
        inputLines.remove(0);
        rovers = new RoverCollection(inputLines);
    }

    public List<Rover> explore() {
        return rovers.move();
    }

    public Position higherPosition() {
        return higherPosition;
    }

    public List<Rover> rovers() {
        return rovers.rovers();
    }

}
