package proj.Project1.Shapes;

import proj.Project1.Interfaces.ThreeDimensionalInterface;

public class Sphere implements ThreeDimensionalInterface {
    public Sphere(int diameter) {
        this.diameter = diameter;
        this.radius = diameter / 2;
    }

    private int diameter = 0;
    private int radius = 0;
    private final String TYPE = "Sphere";

    @Override
    public int getArea() {
        return (int) (4 * Math.PI * Math.pow((double) radius, 2.0));
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
