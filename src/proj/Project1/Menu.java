/**
 * Filename: Menu.java
 * Author: Yael Brown
 * Date: 9/1/2020
 * Brief Purpose of the Program: Java OO Shapes program
 * demostrating inheritance and polymorphism.
 */

package proj.Project1;

import proj.Project1.Shapes.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    boolean cont = false;
    Scanner scan = new Scanner(System.in);

    /**
     * Constructor
     */
    public Menu() {
        this.cont = true;
    }

    /**
     * Runs the menu and uses the supporting helper methods
     */
    public void run() {
        this.greet();

        while (this.cont == true) {
            this.choices();

            int selection = makeSelection();

            checkSelection(selection);

            System.out.println("\n");

            switch (selection) {
                case 1:
                    System.out.println("Enter diameter:\n");
                    int d = scan.nextInt();
                    Circle circle = new Circle(d);
                    System.out.println("The area of circle is: " + circle.getArea());
                    break;
                case 2:
                    System.out.println("Enter length:\n");
                    int l = scan.nextInt();
                    System.out.println("Enter width:\n");
                    int w = scan.nextInt();
                    Rectangle rectangle = new Rectangle(l, w);
                    System.out.println("The area of the rectangle is: " + rectangle.getArea());
                    break;
                case 3:
                    System.out.println("Enter length:\n");
                    int ll = scan.nextInt();
                    System.out.println("Enter width:\n");
                    int ww = scan.nextInt();
                    Square square = new Square(ll, ww);
                    System.out.println("The area of the square is: " + square.getArea());
                    break;
                case 4:
                    System.out.println("Enter base: \n");
                    int b = scan.nextInt();
                    System.out.println("Enter height: \n");
                    int h = scan.nextInt();
                    Triangle triangle = new Triangle(b, h);
                    System.out.println("The area of the triangle is: " + triangle.getArea());
                    break;
                case 5:
                    System.out.println("Enter diameter: \n");
                    int dd = scan.nextInt();
                    Sphere sphere = new Sphere(dd);
                    System.out.println("The area of the sphere is: " + sphere.getArea());
                    break;
                case 6:
                    System.out.println("Enter width: \n");
                    int www = scan.nextInt();
                    System.out.println("Enter height: \n");
                    int hhh = scan.nextInt();
                    System.out.println("Enter length: \n");
                    int lll = scan.nextInt();
                    Cube cube = new Cube(www, hhh, lll);
                    System.out.println("The area of the cube is: " + cube.getArea());
                    break;
                case 7:
                    System.out.println("Enter height: \n");
                    int j = scan.nextInt();
                    System.out.println("Enter diameter: \n");
                    int k = scan.nextInt();
                    Cone cone = new Cone(j, k);
                    System.out.println("The area of the cone is: " + cone.getArea());
                    break;
                case 8:
                    System.out.println("Enter height: \n");
                    int jj = scan.nextInt();
                    System.out.println("Enter diameter: \n");
                    int kk = scan.nextInt();
                    Cylinder cylinder = new Cylinder(jj, kk);
                    System.out.println("The area of the cylinder is: " + cylinder.getArea());
                    break;
                case 9:
                    System.out.println("Enter major radius: \n");
                    int majr = scan.nextInt();
                    System.out.println("Enter minor radius: \n");
                    int minr = scan.nextInt();
                    Torus torus = new Torus(minr, majr);
                    System.out.println("The area of the torus is: " + torus.getArea());
                    break;
                default:
                    exit();
                    this.cont = false;

            }
            if (this.cont == true) {
                this.cont = checkContinue();
            } else {
                exit();
            }
        }

    }

    /**
     * Intro to program
     */
    public void greet() {
        System.out.println("\n********* Welcome to the Java OO Shapes Program **********\n");
    }

    /**
     * Exit of the program that prints the date
     */
    public void exit() {
        DateFormat day = new SimpleDateFormat("MMM dd");
        DateFormat time = new SimpleDateFormat("hh:mm aa");
        Date d = new Date();
        System.out.println("\nThank you for using the program. Today is " + day.format(d) + " at " + time.format(d));
    }

    /**
     * Displays menu choices
     */
    public void choices() {
        System.out.println("Select from the menu below: \n\n" +
                "\t1.  Construct a Circle\n" +
                "\t2.  Construct a Rectangle\n" +
                "\t3.  Construct a Square\n" +
                "\t4.  Construct a Triangle\n" +
                "\t5.  Construct a Sphere\n" +
                "\t6.  Construct a Cube\n" +
                "\t7.  Construct a Cone\n" +
                "\t8.  Construct a Cylinder\n" +
                "\t9.  Construct a Torus\n" +
                "\t10. Exit the program\n"
        );
    }

    /**
     * Takes in input and returns numerical selection
     * @return
     */
    public int makeSelection() {
        return scan.nextInt();
    }

    /**
     * Validates the selection is within the valid size of the menu
     * @param selection
     * @return
     */
    public int checkSelection(int selection) {
        if (selection < 0 || selection > 10) {
            System.out.println("Invalid selection!\nTry again !\n");
            selection = makeSelection();
            checkSelection(selection);
        }
        return selection;
    }

    /**
     * Checks if you would like to continue. If no, returns false to variable that the while loop uses
     * Then breaks out of while loop
     * @return boolean
     */
    private boolean checkContinue() {
        System.out.println("\nWould you like to continue? (Y or N)\n");
        String t = scan.next();

        if (t.toLowerCase().equals("y") || t.toLowerCase().equals("n")) {
            if (t.equals("y")) {
                return true;
            } else {
                this.exit();
                return false;
            }
        } else {
            System.out.println("Invalid selection, try again...");
             return this.checkContinue();
        }
    }

}
