/**
 * Filename: Triangle.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */
package proj.Project1.Shapes;

import proj.Project1.Interfaces.TwoDimensionalInterface;

public class Triangle implements TwoDimensionalInterface {
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    private int base = 0;
    private int height = 0;
    private final String TYPE = "Triangle";

    @Override
    public int getArea() {
        return (this.base * this.height)/2;
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
