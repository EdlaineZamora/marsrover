package br.com.tw.marsrover.exploration;

public class Position {

    public static final String SPACE = " ";
    private final int height;
    private final int width;

    public Position(String higherCordinatesOfExplorationPlan) {
        String[] cordinates = higherCordinatesOfExplorationPlan.split(SPACE);
        height = Integer.valueOf(cordinates[0]);
        width = Integer.valueOf(cordinates[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (height != position.height) return false;
        return width == position.width;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + width;
        return result;
    }

}