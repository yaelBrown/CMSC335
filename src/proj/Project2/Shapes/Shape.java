/**
 * Filename: Shape.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swing GUI that uses event handlers and listeners while expanding
 * on the project 1 Shape theme.
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
