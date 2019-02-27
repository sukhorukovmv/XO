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

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            new MoveController().applyFigure(field, new Point(i, 0), Figure.O);
            new MoveController().applyFigure(field, new Point(i, 1), Figure.O);
            new MoveController().applyFigure(field, new Point(i, 2), Figure.O);
            assertEquals(Figure.O, new WinnerController().getWinner(field).get());
        }
    }

    public void checkWinnerOnColumns() throws AlreadyOccupiedException, InvalidPointException {

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            new MoveController().applyFigure(field, new Point(0, i), Figure.O);
            new MoveController().applyFigure(field, new Point(1, i), Figure.O);
            new MoveController().applyFigure(field, new Point(2, i), Figure.O);
            assertEquals(Figure.O, new WinnerController().getWinner(field).get());
        }
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
//        if (new WinnerController().getWinner(field).isPresent()) System.out.println("Draw");
    }

    @Test
    public void negativeCheckWinnerOnColumns() throws AlreadyOccupiedException, InvalidPointException {

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            new MoveController().applyFigure(field, new Point(0, i), Figure.O);
            new MoveController().applyFigure(field, new Point(1, i), Figure.X);
            new MoveController().applyFigure(field, new Point(2, i), Figure.O);
            //assertEquals(Optional.empty(), new WinnerController().getWinner(field).get());
            //           assertNull(new WinnerController().getWinner(field).get());
            if (new WinnerController().getWinner(field).isPresent()) fail();

        }
    }

    @Test
    public void negativeCheckWinnerOnRows() throws AlreadyOccupiedException, InvalidPointException {

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            new MoveController().applyFigure(field, new Point(i, 0), Figure.O);
            new MoveController().applyFigure(field, new Point(i, 1), Figure.X);
            new MoveController().applyFigure(field, new Point(i, 2), Figure.O);
//            assertEquals(Optional.empty(), new WinnerController().getWinner(field).get());
            //           assertNull(new WinnerController().getWinner(field).get());
            if (new WinnerController().getWinner(field).isPresent()) fail();

        }
    }

    @Test
    public void checkWinner() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);

        new MoveController().applyFigure(field, new Point(0, 2), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(2, 0), Figure.O);

        Optional<Figure> optionalFigure = new WinnerController().getWinner(field);

        //if (!optionalFigure.isPresent())

        //    fail();
        // assertEquals(Figure.X, new WinnerController().getWinner(field).get());

    }
}