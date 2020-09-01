package proj.Project1.Shapes;

import proj.Project1.Interfaces.TwoDimensionalInterface;

public class Rectangle implements TwoDimensionalInterface {
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    private int length = 0;
    private int width = 0;
    private final String TYPE = "Rectangle";

    @Override
    public int getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
