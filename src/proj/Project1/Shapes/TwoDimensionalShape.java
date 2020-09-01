/**
 * Filename: TwoDimensionalShape.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project1.Shapes;

/**
 * Class is used for custom area and toString strings for unspecified two dimensional shapes
 */
public class TwoDimensionalShape {
    public TwoDimensionalShape () {}

    public String getArea() {
        return "a TwoDimensionalShape has an area";
    }

    @Override
    public String toString() {
        return "a TwoDimensionalShape is a shape";
    }
}
