package github.sukhorukovmv.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void getX() {
        Point inputPoint = new Point(2, 1);
        assertEquals(2, inputPoint.getX());
    }

    @Test
    public void getY() {
        Point inputPoint = new Point(2, 1);
        assertEquals(1, inputPoint.getY());

    }
}