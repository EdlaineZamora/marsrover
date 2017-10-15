package br.com.tw.marsrover.exploration;

public class Position {

    public static final String SPACE = " ";
    private int height;
    private int width;

    public Position(String cordinates) {
        String[] cordinatesValues = cordinates.split(SPACE);
        width = Integer.valueOf(cordinatesValues[0]);
        height = Integer.valueOf(cordinatesValues[1]);
    }

    public Position moveWidthMinus() {
        width--;
        return new Position(String.valueOf(width) + " " + String.valueOf(height));
    }

    public Position moveHeightMore() {
        height++;
        return new Position(String.valueOf(width) + " " + String.valueOf(height));
    }

    public Position moveHeightMinus() {
        height--;
        return new Position(String.valueOf(width) + " " + String.valueOf(height));
    }

    public Position moveWidthMore() {
        width++;
        return new Position(String.valueOf(width) + " " + String.valueOf(height));
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