package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;

public class WinnerController {
    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.getX(), p.getY() + 1)))
                    return field.getFigure(new Point(i, 0));
                if (check(field, new Point(0, i), p -> new Point(p.getX() + 1, p.getY())))
                    return field.getFigure(new Point(0, i));
            }
            if (check(field, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1)))
                return field.getFigure(new Point(0, 0));
            if (check(field, new Point(0, field.getSize() - 1), p -> new Point(p.getX() + 1, p.getY() - 1)))
                return field.getFigure(new Point(0, field.getSize() - 1));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null; // тут возвращать ничью
    }

    private boolean check(final Field field, final Point currentPoint, final IPointChanger pointChanger) {
        final Point nextPoint = pointChanger.next(currentPoint);
        try {
            if (field.getFigure(currentPoint) == null || field.getFigure(nextPoint) == null) return false;
            if (field.getFigure(currentPoint) != field.getFigure(nextPoint)) return false;
        } catch (InvalidPointException e) { //если вылезли за границы значит строка совпала
            return true;
        }

        return check(field, nextPoint, pointChanger);
    }

    private interface IPointChanger {
        Point next(final Point point);
    }

}
