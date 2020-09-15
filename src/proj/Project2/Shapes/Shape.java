/**
 * Filename: Shape.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project2.Shapes;

import javax.swing.*;

public class Shape {
    public Shape() { }

    private final ImageIcon img = new ImageIcon();
    private final String TYPE = "";

    public String getTYPE() {
        return TYPE;
    }

    public ImageIcon getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "a Shape is an object";
    }
}
