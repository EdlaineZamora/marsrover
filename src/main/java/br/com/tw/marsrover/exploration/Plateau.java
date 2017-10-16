package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.exploration.rover.Rover;
import br.com.tw.marsrover.exploration.rover.RoverCollection;

import java.util.List;

public class Plateau {

    private final RoverCollection rovers;

    public Plateau(List<String> inputLines) {
        removeHigherPosition(inputLines);
        rovers = new RoverCollection(inputLines);
    }

    public List<Rover> explore() {
        return rovers.move();
    }

    public List<Rover> rovers() {
        return rovers.roversCopy();
    }

    private String removeHigherPosition(List<String> inputLines) {
        return inputLines.remove(0);
    }

}
