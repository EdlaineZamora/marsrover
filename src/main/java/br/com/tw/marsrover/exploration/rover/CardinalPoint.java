package br.com.tw.marsrover.exploration.rover;

import java.util.List;

public enum CardinalPoint {

    N, E, S, W;

    public static final int LAST_CARDINAL_POINT = 3;
    public static final int FIRST_CARDINAL_POINT = 0;
    public static final String RIGHT = "R";
    public static final String EMPTY = "";

    public static CardinalPoint nextCardinalPoint(CardinalPoint cardinalPoint, List<Moviment> moviments) {
        CardinalPoint cardinalPointFound = cardinalPoint;

        for (Moviment moviment : moviments) {
            String[] direction = moviment.direction().split(EMPTY);
            for (int i = 0; i < direction.length; i++) {
                if (direction[i].equals(RIGHT)) {
                    cardinalPointFound = nextCardinalPointForRightDirection(cardinalPointFound);
                } else {
                    cardinalPointFound = nextCardinalPointForLeftDirection(cardinalPointFound);
                }
            }
        }

        return cardinalPointFound;
    }

    private static CardinalPoint nextCardinalPointForLeftDirection(CardinalPoint cardinalPointFound) {
        if (cardinalPointFound.ordinal() == FIRST_CARDINAL_POINT) {
            return W;
        }
        return values()[cardinalPointFound.ordinal() - 1];
    }

    private static CardinalPoint nextCardinalPointForRightDirection(CardinalPoint cardinalPointFound) {
        if (cardinalPointFound.ordinal() == LAST_CARDINAL_POINT) {
            return N;
        }
        return values()[cardinalPointFound.ordinal() + 1];
    }

}
