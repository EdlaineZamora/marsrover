package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.rover.Rover;

import java.util.ArrayList;
import java.util.List;

public class RoverCollection {

    public static final String ONLY_LETTERS_PATTERN = "[^A-Z]";
    private List<Rover> rovers = new ArrayList<>();

    public RoverCollection(List<String> inputLines) {
        for (int i = 0; i < inputLines.size(); i+=2) {
            Position position = new Position(inputLines.get(i));
            Rover rover = new Rover(position, extractCardinalPoint(inputLines.get(i)), inputLines.get(i + 1));
            rovers.add(rover);
        }
    }

    public List<Rover> rovers() {
        return new ArrayList<>(rovers);
    }

    private String extractCardinalPoint(String positionElements) {
        return positionElements.replaceAll(ONLY_LETTERS_PATTERN, "");
    }

}
