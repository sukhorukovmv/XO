package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Point;

import java.util.Random;

public class RandomPoint {
    public Point getRandomPoint(final int maxCoordinate) {
        return new Point(new Random().nextInt(maxCoordinate), new Random().nextInt(maxCoordinate));
    }
}
