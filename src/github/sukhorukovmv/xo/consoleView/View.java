package github.sukhorukovmv.xo.consoleView;

import github.sukhorukovmv.xo.model.Field;
import github.sukhorukovmv.xo.model.Figure;
import github.sukhorukovmv.xo.model.Point;
import github.sukhorukovmv.xo.model.exceptions.InvalidPointException;

import java.util.Scanner;

public class View {
    public void showField(final Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            try {
                showLine(field, i);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
            if (i != field.getSize() - 1) separate(field);
        }
    }

    public Point enterPoint() {
        int coordinateX = enterCoordinate("X");
        int coordinateY = enterCoordinate("Y");
        return new Point(coordinateX - 1, coordinateY - 1);
    }

    public int enterFieldSize() {
        System.out.print("Please enter Field size: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private void showLine(final Field field, final int lineNumber) throws InvalidPointException {
        for (int i = 0; i < field.getSize(); i++) {
            Figure figure = field.getFigure(new Point(lineNumber, i));
            String directSlash = (i == field.getSize() - 1) ? " " : " |";
            System.out.print(" " + (figure == null ? " " : figure) + directSlash);
        }
        System.out.println();
    }

    private int enterCoordinate(final String coordinate) {
        System.out.print("Please enter coordinate " + coordinate + ": ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private void separate(final Field field) {
        int lenghtSeparate = field.getSize() * 4;
        for (int i = 0; i < lenghtSeparate; i++) {
            System.out.print("~");
        }
        System.out.println();

    }
}
