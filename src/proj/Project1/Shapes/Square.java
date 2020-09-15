/**
 * Filename: Square.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project1.Shapes;

import proj.Project1.Interfaces.TwoDimensionalInterface;

public class Square implements TwoDimensionalInterface {
    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }

    private int length = 0;
    private int width = 0;
    private final String TYPE = "Square";

    @Override
    public int getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
