/**
 * Filename: Cylinder.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project1.Shapes;

import proj.Project1.Interfaces.ThreeDimensionalInterface;

public class Cylinder implements ThreeDimensionalInterface {
    public Cylinder(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
        this.radius = this.diameter / 2;
    }

    private int diameter;
    private int height;
    private int radius;
    private final String TYPE = "Cylinder";

    @Override
    public int getArea() {
        return (int) (2 * Math.PI * Math.pow(radius, 2)) * height;
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
