package proj.Project1.Shapes;

import proj.Project1.Interfaces.TwoDimensionalInterface;

public class Circle implements TwoDimensionalInterface {

    public Circle(int diameter) {
        this.diameter = diameter;
        this.radius = this.diameter/2;
    }

    private int diameter = 0;
    private int radius = 0;
    private final String TYPE = "Circle";

    @Override
    public int getArea() {
        return (int) (2 * Math.pow(Math.PI, (double) radius));
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}