package github.sukhorukovmv.xo.controllers;

import github.sukhorukovmv.xo.model.Field;

import java.util.Random;

public class RandomField {
    public Field getRandomField() {
        int minFieldSize = 3;
        int maxFieldSize = 11;
        int diff = maxFieldSize - minFieldSize;
        return new Field(new Random().nextInt(diff + 1) + minFieldSize);
    }
}
