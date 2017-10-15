package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoverCollection {

    public static final String ONLY_LETTERS_PATTERN = "[^A-Z]";
    public static final String EMPTY = "";
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

    public List<Rover> move() {
        return rovers.stream()
                .map(Rover::move)
                .collect(Collectors.toList());
    }

    private CardinalPoint extractCardinalPoint(String positionElements) {
        String cardinalPointLetter = positionElements.replaceAll(ONLY_LETTERS_PATTERN, EMPTY);

        return CardinalPoint.valueOf(cardinalPointLetter);
    }

}
