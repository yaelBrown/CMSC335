/**
 * Filename: Rectangle.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project2.Shapes;

import proj.Project2.Interfaces.TwoDimensionalInterface;

import javax.swing.*;

public class Rectangle extends Shape implements TwoDimensionalInterface {
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    private int length = 0;
    private int width = 0;
    private final String TYPE = "Rectangle";

    @Override
    public String getTYPE() {
        return TYPE;
    }

    public ImageIcon getImg() {
        return img;
    }

    private final ImageIcon img = new ImageIcon(getClass().getResource("../rectangle.png"));

    @Override
    public int getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
