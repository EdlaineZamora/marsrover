package br.com.tw.marsrover.exploration;

public class Position {

    public static final String SPACE = " ";
    private int width;
    private int height;

    public Position(String cordinates) {
        String[] cordinatesValues = cordinates.split(SPACE);
        width = Integer.valueOf(cordinatesValues[0]);
        height = Integer.valueOf(cordinatesValues[1]);
    }

    private Position(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Position moveWidthMinus(int move) {
        width -= move;
        return new Position(width, height);
    }

    public Position moveHeightMore(int move) {
        height += move;
        return new Position(width, height);
    }

    public Position moveHeightMinus(int move) {
        height -= move;
        return new Position(width, height);
    }

    public Position moveWidthMore(int move) {
        width += move;
        return new Position(width, height);
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

    @Override
    public String toString() {
        return width + " " + height;
    }

}