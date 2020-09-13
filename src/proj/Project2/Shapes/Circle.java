/**
 * Filename: Circle.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */
package proj.Project1.Shapes;

import proj.Project1.Interfaces.TwoDimensionalInterface;

public class Circle implements TwoDimensionalInterface {

    public Circle(int diameter) {
        this.diameter = diameter;
        this.radius = this.diameter/2;
    }

    private int diameter = 0;
    private int radius = 0;
    private final String TYPE = "Circle";

    @Override
    public int getArea() {
        return (int) (2 * Math.PI * Math.pow((double) radius, 2));
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
