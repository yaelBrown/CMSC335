package proj.Project1.Shapes;

import proj.Project1.Interfaces.ThreeDimensionalInterface;

public class Cone implements ThreeDimensionalInterface {
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
    public int getArea() {
        return (int) ((int) Math.PI * this.radius * (this.radius + Math.sqrt((Math.pow((double) this.height,2) + Math.pow((double) this.radius, 2)))));
    }

    @Override
    public String toString() {
        return "a " + TYPE + out;
    }
}
