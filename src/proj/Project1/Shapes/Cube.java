/**
 * Filename: Cube.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project1.Shapes;

import proj.Project1.Interfaces.ThreeDimensionalInterface;

public class Cube implements ThreeDimensionalInterface {
    public Cube(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    private int width;
    private int height;
    private int length;
    private final String TYPE = "Cube";

    @Override
    public int getArea() {
        return this.height * this.width * this.length;
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
