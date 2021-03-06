package github.sukhorukovmv.xo.model;

import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;

public class Field {
    private final int fieldSize;
    private final int minCoordinate;
    private final Figure[][] field;
    private static int MAX_FIELD_SIZE = 11;
    private static int MIN_FIELD_SIZE = 3;

    public Field(int fieldSize) {
        fieldSize = fieldSize < MIN_FIELD_SIZE ? MIN_FIELD_SIZE : fieldSize;
        fieldSize = fieldSize > MAX_FIELD_SIZE ? MAX_FIELD_SIZE : fieldSize;
        this.fieldSize = fieldSize;
        this.field = new Figure[fieldSize][fieldSize];
        this.minCoordinate = 0;
    }

    public int getSize() {
        return fieldSize;
    }


    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX()) && checkCoordinate(point.getY());
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= this.minCoordinate && coordinate < field.length;
    }
}
