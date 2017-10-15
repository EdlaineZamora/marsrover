package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoverCollection {

    public static final String ONLY_LETTERS_PATTERN = "[^A-Z]";
    public static final String MOVIMENT_PATTERN = "M+";
    public static final String DIRECTION_PATTERN = "[LR+]";
    public static final String EMPTY = "";
    private List<Rover> rovers = new ArrayList<>();

    public RoverCollection(List<String> inputLines) {
        for (int i = 0; i < inputLines.size(); i+= 2) {
            Position position = new Position(inputLines.get(i));
            Rover rover = new Rover(position, extractCardinalPoint(inputLines.get(i)), extractMoviments(inputLines.get(i + 1)));
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

    private List<String> extractMoviments(String moviments) {
        List<String> movimentsGroup = new ArrayList<>();

        String[] directions = moviments.split(MOVIMENT_PATTERN);
        String[] movimentsSequence = moviments.split(DIRECTION_PATTERN);

        for (int i = 0; i < directions.length; i++) {
            movimentsGroup.add(directions[i].concat(movimentsSequence[i+1]));
        }

        return movimentsGroup;
    }

    private CardinalPoint extractCardinalPoint(String positionElements) {
        String cardinalPointLetter = positionElements.replaceAll(ONLY_LETTERS_PATTERN, EMPTY);

        return CardinalPoint.valueOf(cardinalPointLetter);
    }

}
