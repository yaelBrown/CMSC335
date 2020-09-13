/**
 * Filename: ThreeDimensionalShape.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project1.Shapes;

/**
 * Class is used for returning custom area and toString methods for non-specified shapes
 */
public class ThreeDimensionalShape {
    public ThreeDimensionalShape() {}

    public String getArea() {
        return "a ThreeDimensionalShape has an volume";
    }

    @Override
    public String toString() {
        return "a ThreeDimensionalShape is a shape";
    }
}
