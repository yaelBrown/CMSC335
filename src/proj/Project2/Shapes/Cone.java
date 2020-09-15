/**
 * Filename: Cone.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swing GUI that uses event handlers and listeners while expanding
 * on the project 1 Shape theme.
 */

package proj.Project2.Shapes;

import proj.Project2.Interfaces.ThreeDimensionalInterface;

import javax.swing.*;

public class Cone extends Shape implements ThreeDimensionalInterface {
    public Cone(int height, int diameter) {

        this.height = height;
        this.diameter = diameter;
        this.radius = this.diameter / 2;
    }

    private int height;
    private int diameter;
    private int radius;
    private final String TYPE = "Cone";

    @Override
    public String getTYPE() {
        return TYPE;
    }

    public ImageIcon getImg() {
        return img;
    }

    private final ImageIcon img = new ImageIcon(getClass().getResource("../cone.png"));

    @Override
    public int getArea() {
        return (int) ((int) Math.PI * this.radius * (this.radius + Math.sqrt((Math.pow((double) this.height,2) + Math.pow((double) this.radius, 2)))));
    }

    @Override
    public String toString() {
        return "a " + TYPE + " with area of " + getArea();
    }
}
