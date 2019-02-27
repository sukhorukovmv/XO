package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.AlreadyOccupiedException;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void checkWinnerOnRows() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);

        new MoveController().applyFigure(field, new Point(0, 0), Figure.O);
        new MoveController().applyFigure(field, new Point(0, 1), Figure.O);
        new MoveController().applyFigure(field, new Point(0, 2), Figure.O);

        assertEquals(Figure.O, new WinnerController().getWinner(field).get());
    }

    @Test
    public void checkWinnerOnMainDiag() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);

        new MoveController().applyFigure(field, new Point(0, 0), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(2, 2), Figure.X);

        assertEquals(Figure.X, new WinnerController().getWinner(field).get());
    }

    @Test
    public void checkWinnerOnSideDiag() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);

        new MoveController().applyFigure(field, new Point(0, 2), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(2, 0), Figure.X);

        assertEquals(Figure.X, new WinnerController().getWinner(field).get());
    }

    @Test
    public void checkWinnerDraw() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);

        new MoveController().applyFigure(field, new Point(0, 0), Figure.O);
        new MoveController().applyFigure(field, new Point(0, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(0, 2), Figure.O);
        new MoveController().applyFigure(field, new Point(1, 0), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 2), Figure.O);
        new MoveController().applyFigure(field, new Point(2, 0), Figure.X);
        new MoveController().applyFigure(field, new Point(2, 1), Figure.O);
        new MoveController().applyFigure(field, new Point(2, 2), Figure.X);

        Optional<Figure> optionalFigure = new WinnerController().getWinner(field);

        if (optionalFigure.isPresent())
            fail();
    }

    @Test
    public void checkWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);

        new MoveController().applyFigure(field, new Point(0, 2), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(2, 0), Figure.O);

        Optional<Figure> optionalFigure = new WinnerController().getWinner(field);

        if (!optionalFigure.isPresent())
            fail();
       // assertEquals(Figure.X, new WinnerController().getWinner(field).get());

    }
}