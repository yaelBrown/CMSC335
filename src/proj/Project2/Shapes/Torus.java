/**
 * Filename: Torus.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swing GUI that uses event handlers and listeners while expanding
 * on the project 1 Shape theme.
 */

package proj.Project2.Shapes;

import proj.Project2.Interfaces.ThreeDimensionalInterface;

import javax.swing.*;

public class Torus extends Shape implements ThreeDimensionalInterface {
    public Torus(int minorRadius, int majorRadius) {
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
    }

    private int minorRadius;
    private int majorRadius;
    private final String TYPE = "Torus";

    @Override
    public String getTYPE() {
        return TYPE;
    }

    public ImageIcon getImg() {
        return img;
    }

    private final ImageIcon img = new ImageIcon(getClass().getResource("../torus.png"));

    @Override
    public int getArea() {
        return (int) ((2 * Math.PI * minorRadius) * (2 * Math.PI * majorRadius));
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
