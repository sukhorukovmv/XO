package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerRows() {
        final Field field = new Field(3);
        final WinnerController winner = new WinnerController();

        try {
            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.O);
            assertEquals(Figure.O, winner.getWinner(field));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }
}