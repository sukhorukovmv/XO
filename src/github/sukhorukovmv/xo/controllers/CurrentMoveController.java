package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;

import java.util.Optional;

public class CurrentMoveController {
    public Optional<Figure> currentFigure(final Field field) {
        int count = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                try {
                    if (field.getFigure(new Point(i, j)) != null) ++count;
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }
        if (count == field.getSize() * field.getSize()) return Optional.empty();
        else if (count % 2 == 0) return Optional.of(Figure.X);
        else return Optional.of(Figure.O);

    }
}
