package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoverCollection {

    private static final String ONLY_LETTERS_PATTERN = "[^A-Z]";
    private static final String MOVIMENT_PATTERN = "M+";
    private static final String DIRECTION_PATTERN = "[LR+]";
    private static final String EMPTY = "";
    private List<Rover> rovers = new ArrayList<>();

    public RoverCollection(List<String> inputLines) {
        for (int i = 0; i < inputLines.size(); i+= 2) {
            Position position = new Position(inputLines.get(i));
            Rover rover = new Rover(position, extractCardinalPoint(inputLines.get(i)), extractMoviments(inputLines.get(i + 1)));
            rovers.add(rover);
        }
    }

    public List<Rover> roversCopy() {
        return new ArrayList<>(rovers);
    }

    public List<Rover> move() {
        return rovers.stream()
                .map(Rover::move)
                .collect(Collectors.toList());
    }

    private List<Moviment> extractMoviments(String moviments) {
        List<Moviment> movimentsGroup = new ArrayList<>();

        String[] directions = moviments.split(MOVIMENT_PATTERN);
        String[] movimentsSequence = getMovimentsSequence(moviments);

        for (int i = 0; i < directions.length; i++) {
            Moviment moviment = new Moviment(directions[i].concat(movimentsSequence[i]));
            movimentsGroup.add(moviment);
        }

        return movimentsGroup;
    }

    private String[] getMovimentsSequence(String moviments) {
        String[] movimentsSequence = moviments.split(DIRECTION_PATTERN);
        List<String> resultMovimentSequence = new ArrayList<>();

        for (int i = 0; i < movimentsSequence.length; i++) {
            if (!movimentsSequence[i].isEmpty()) {
                resultMovimentSequence.add(movimentsSequence[i]);
            }
        }

        return resultMovimentSequence.stream()
                .toArray(String[]::new);
    }

    private CardinalPoint extractCardinalPoint(String positionElements) {
        String cardinalPointLetter = positionElements.replaceAll(ONLY_LETTERS_PATTERN, EMPTY);

        return CardinalPoint.valueOf(cardinalPointLetter);
    }

}
