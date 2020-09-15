/**
 * Filename: Cylinder.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swing GUI that uses event handlers and listeners while expanding
 * on the project 1 Shape theme.
 */

package proj.Project2.Shapes;

import proj.Project2.Interfaces.ThreeDimensionalInterface;

import javax.swing.*;

public class Cylinder extends Shape implements ThreeDimensionalInterface {
    public Cylinder(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
        this.radius = this.diameter / 2;
    }

    private int diameter;

    private int height;
    private int radius;
    private final String TYPE = "Cylinder";
    public ImageIcon getImg() {
        return img;
    }

    private final ImageIcon img = new ImageIcon(getClass().getResource("../cylinder.png"));

    @Override
    public String getTYPE() {
        return TYPE;
    }

    @Override
    public int getArea() {
        return (int) (2 * Math.PI * Math.pow(radius, 2)) * height;
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
