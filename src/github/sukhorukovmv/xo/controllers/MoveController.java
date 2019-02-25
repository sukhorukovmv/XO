package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.AlreadyOccupiedException;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;

public class MoveController {
    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
