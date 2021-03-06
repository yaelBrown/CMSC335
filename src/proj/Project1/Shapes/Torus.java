/**
 * Filename: Torus.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */
package proj.Project1.Shapes;

import proj.Project1.Interfaces.ThreeDimensionalInterface;

public class Torus implements ThreeDimensionalInterface {
    public Torus(int minorRadius, int majorRadius) {
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
    }

    private int minorRadius;
    private int majorRadius;
    private final String TYPE = "Torus";

    @Override
    public int getArea() {
        return (int) ((2 * Math.PI * minorRadius) * (2 * Math.PI * majorRadius));
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
