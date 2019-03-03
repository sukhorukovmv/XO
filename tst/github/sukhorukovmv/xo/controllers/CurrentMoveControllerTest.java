package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.AlreadyOccupiedException;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentFigureWhenExpectedO() throws AlreadyOccupiedException, InvalidPointException {
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            new MoveController().applyFigure(field, new Point(0, i), Figure.X);
            new MoveController().applyFigure(field, new Point(1, i), Figure.O);
            new MoveController().applyFigure(field, new Point(2, i), Figure.X);
            assertEquals(Figure.O, new CurrentMoveController().currentFigure(field).get());
            //           assertNull(new WinnerController().getWinner(field).get());
            //if (new WinnerController().getWinner(field).isPresent()) fail();

        }
    }

  /*  @Test
    public void currentFigureWhenExpectedX() throws AlreadyOccupiedException, InvalidPointException {
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            new MoveController().applyFigure(field, new Point(0, i), Figure.X);
            new MoveController().applyFigure(field, new Point(1, i), Figure.O);
            assertEquals(Figure.X, new CurrentMoveController().currentFigure(field).get());
            //           assertNull(new WinnerController().getWinner(field).get());
            //if (new WinnerController().getWinner(field).isPresent()) fail();

        }
    }
    */

    @Test
    public void Draw() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        new MoveController().applyFigure(field, new Point(0, 0), Figure.X);
        new MoveController().applyFigure(field, new Point(0, 1), Figure.O);
        new MoveController().applyFigure(field, new Point(0, 2), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 0), Figure.O);
        new MoveController().applyFigure(field, new Point(1, 1), Figure.X);
        new MoveController().applyFigure(field, new Point(1, 2), Figure.O);
        new MoveController().applyFigure(field, new Point(2, 0), Figure.X);
        new MoveController().applyFigure(field, new Point(2, 1), Figure.O);
        new MoveController().applyFigure(field, new Point(2, 2), Figure.X);
//        assertEquals(Figure.X, new CurrentMoveController().currentFigure(field).get());
        //           assertNull(new WinnerController().getWinner(field).get());
        if (new CurrentMoveController().currentFigure(field).isPresent()) fail();

    }

    @Test
    public void currentFigureWhenExpectedX() throws AlreadyOccupiedException, InvalidPointException {

        final Field field = new RandomField().getRandomField();
        new MoveController().applyFigure(field, new RandomPoint().getRandomPoint(field.getSize()), Figure.X);
        new MoveController().applyFigure(field, new RandomPoint().getRandomPoint(field.getSize()), Figure.O);
        assertEquals(Figure.X, new CurrentMoveController().currentFigure(field).get());
        //           assertNull(new WinnerController().getWinner(field).get());
        //if (new WinnerController().getWinner(field).isPresent()) fail();

    }
}


