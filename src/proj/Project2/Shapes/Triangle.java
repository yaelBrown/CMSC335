/**
 * Filename: Triangle.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */
package proj.Project2.Shapes;

import proj.Project2.Interfaces.TwoDimensionalInterface;

import javax.swing.*;

public class Triangle extends Shape implements TwoDimensionalInterface {
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    private int base = 0;
    private int height = 0;
    private final String TYPE = "Triangle";

    @Override
    public String getTYPE() {
        return TYPE;
    }

    public ImageIcon getImg() {
        return img;
    }

    private final ImageIcon img = new ImageIcon(getClass().getResource("../triangle.png"));

    @Override
    public int getArea() {
        return (this.base * this.height)/2;
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
