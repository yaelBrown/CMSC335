/**
 * Filename: Sphere.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project2.Shapes;

import proj.Project2.Interfaces.ThreeDimensionalInterface;

import javax.swing.*;

public class Sphere extends Shape implements ThreeDimensionalInterface {
    public Sphere(int diameter) {
        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    private int diameter = 0;
    private int radius = 0;
    private final String TYPE = "Sphere";
    private final ImageIcon img = new ImageIcon(getClass().getResource("../sphere.png"));

    @Override
    public int getArea() {
        return (int) (4 * Math.PI * Math.pow((double) radius, 2.0));
    }

    @Override
    public String getTYPE() {
        return TYPE;
    }

    public ImageIcon getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
