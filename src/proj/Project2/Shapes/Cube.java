/**
 * Filename: Cube.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swing GUI that uses event handlers and listeners while expanding
 * on the project 1 Shape theme.
 */

package proj.Project2.Shapes;

import proj.Project2.Interfaces.ThreeDimensionalInterface;

import javax.swing.*;

public class Cube extends Shape implements ThreeDimensionalInterface {
    public Cube(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    private int width;
    private int height;
    private int length;

    @Override
    public String getTYPE() {
        return TYPE;
    }

    private final String TYPE = "Cube";

    public ImageIcon getImg() {
        return img;
    }

    private final ImageIcon img = new ImageIcon(getClass().getResource("../cube.png"));

    @Override
    public int getArea() {
        return this.height * this.width * this.length;
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
