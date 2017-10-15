package br.com.tw.marsrover.exploration.rover;

import java.util.List;

import static java.util.Arrays.stream;

public enum CardinalPoint {

    N, L, S, O;

    public static final int LAST_CARDINAL_POINT = 3;
    public static final int FIRST_CARDINAL_POINT = 0;

    public static CardinalPoint nextCardinalPoint(CardinalPoint cardinalPoint, List<Moviment> moviments) {
        CardinalPoint cardinalPointFound = stream(values())
                .filter(cardinalPoint1 -> cardinalPoint.equals(cardinalPoint))
                .findAny().get();

        for (Moviment moviment : moviments) {
            if (moviment.isRight()) {
                cardinalPointFound = nextCardinalPointForRightDirection(cardinalPointFound);
            } else {
                cardinalPointFound = nextCardinalPointForLeftDirection(cardinalPointFound);
            }
        }
        return cardinalPointFound;
    }

    private static CardinalPoint nextCardinalPointForLeftDirection(CardinalPoint cardinalPointFound) {
        if (cardinalPointFound.ordinal() == FIRST_CARDINAL_POINT) {
            return O;
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
