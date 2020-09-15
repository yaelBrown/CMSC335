/**
 * Filename: GUI.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swing GUI that uses event handlers and listeners while expanding
 * on the project 1 Shape theme.
 */

package proj.Project2;

import proj.Project2.Shapes.*;
import proj.Project2.Shapes.Rectangle;
import proj.Project2.Shapes.Shape;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public GUI() {
        System.out.println("GUI: Creating GUI");
        frame = new JFrame("Shape Visualizer");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = menu();

        System.out.println("GUI: Make frame visable");
        frame.add(panel);
        frame.setVisible(true);

        System.out.println("GUI: Finished setting up and displaying GUI");
    }

    private JPanel panel;
    private JFrame frame;
    private String currentPage;
    private Shape selectedShape;

    private JPanel menu() {
        System.out.println("GUI: Generating menu....");
        JPanel out = new JPanel(new GridLayout(3,1,10,10));

        JLabel title = new JLabel("Select a Shape");
        title.setFont(new Font("Serif", Font.PLAIN, 30));

        String[] twoD = { "--None--", "Circle", "Rectangle", "Square", "Triangle" };
        String[] threeD = { "--None--", "Cone", "Cube", "Cylinder", "Sphere", "Torus" };

        JComboBox twoDDropdown = new JComboBox(twoD);
        JComboBox threeDDropdown = new JComboBox(threeD);

        twoDDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(twoDDropdown.getSelectedItem().toString());
            }
        });
        threeDDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(threeDDropdown.getSelectedItem().toString());
            }
        });

        out.add(title);
        out.add(twoDDropdown);
        out.add(threeDDropdown);

        out.setBorder(new EmptyBorder(5,200,300,200));

        this.currentPage = "menu";
        System.out.println("GUI:    CurrentPage: Menu");

        return out;
    }

    private JPanel selection(String sel) {
        JPanel out = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel title = new JLabel(sel);
        title.setFont(new Font("Serif", Font.PLAIN, 30));

        out.add(title);
        out.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonPnl = new JPanel(new FlowLayout());

        switch(sel) {
            case "Circle":
            case "Sphere":
                JPanel circTemp = new JPanel(new GridLayout(1,2));
                JLabel diameterLabel = new JLabel("Diameter");
                JTextArea diameterTextarea = new JTextArea();

                circTemp.add(diameterLabel);
                circTemp.add(diameterTextarea);

                out.add(circTemp);

                JButton circContBtn = new JButton("Continue");
                JButton cirCbackBtn = new JButton("Back");

                circContBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String d = diameterTextarea.getText();

                        if (sel.equals("Circle")) {
                            selectedShape = new Circle(Integer.parseInt(d));
                        } else {
                            selectedShape = new Sphere(Integer.parseInt(d));
                        }

                        changePanel("");
                    }
                });
                cirCbackBtn.addActionListener(backBtn());

                buttonPnl.add(circContBtn);
                buttonPnl.add(cirCbackBtn);

                break;
            case "Cone":
                JPanel coneTemp = new JPanel(new GridLayout(2,2));
                JLabel heightLabel = new JLabel("Height");
                JTextArea heightTextarea = new JTextArea();
                JLabel diameterConeLabel = new JLabel("Diameter");
                JTextArea diameterConeTextarea = new JTextArea();

                coneTemp.add(heightLabel);
                coneTemp.add(heightTextarea);
                coneTemp.add(diameterConeLabel);
                coneTemp.add(diameterConeTextarea);

                out.add(coneTemp);

                JButton coneContBtn = new JButton("Continue");
                JButton coneBackBtn = new JButton("Back");

                coneContBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String coneHeightVal = heightTextarea.getText();
                        String coneDiameterVal = diameterConeTextarea.getText();

                        selectedShape = new Cone(Integer.parseInt(coneHeightVal), Integer.parseInt(coneDiameterVal));

                        changePanel("");
                    }
                });
                coneBackBtn.addActionListener(backBtn());

                buttonPnl.add(coneContBtn);
                buttonPnl.add(coneBackBtn);

                break;
            case "Cube":
                JPanel cubeTemp = new JPanel(new GridLayout(3,2));
                JLabel cubeWidthLabel = new JLabel("Width");
                JTextArea cubeWidthTextarea = new JTextArea();
                JLabel cubeHeightLabel = new JLabel("Height");
                JTextArea cubeHeightTextarea = new JTextArea();
                JLabel cubeLengthLabel = new JLabel("Length");
                JTextArea cubeLengthTextarea = new JTextArea();

                cubeTemp.add(cubeWidthLabel);
                cubeTemp.add(cubeWidthTextarea);
                cubeTemp.add(cubeHeightLabel);
                cubeTemp.add(cubeHeightTextarea);
                cubeTemp.add(cubeLengthLabel);
                cubeTemp.add(cubeLengthTextarea);

                JButton cubeContBtn = new JButton("Continue");
                JButton cubeBackBtn = new JButton("Back");

                cubeContBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cubeWidthVal = cubeWidthTextarea.getText();
                        String cubeHeightVal = cubeHeightTextarea.getText();
                        String cubeLengthVal = cubeLengthTextarea.getText();

                        selectedShape = new Cube(Integer.parseInt(cubeWidthVal), Integer.parseInt(cubeHeightVal), Integer.parseInt(cubeLengthVal));

                        changePanel("");
                    }
                });
                cubeBackBtn.addActionListener(backBtn());

                buttonPnl.add(cubeContBtn);
                buttonPnl.add(cubeBackBtn);

                out.add(cubeTemp);
                break;
            case "Cylinder":
                JPanel cylTemp = new JPanel(new GridLayout(2,2));
                JLabel cylDiameterLabel = new JLabel("Diamter");
                JTextArea cylDiameterTextarea = new JTextArea();
                JLabel cylHeightLabel = new JLabel("Height");
                JTextArea cylHeightTextarea = new JTextArea();

                cylTemp.add(cylDiameterLabel);
                cylTemp.add(cylDiameterTextarea);
                cylTemp.add(cylHeightLabel);
                cylTemp.add(cylHeightTextarea);

                JButton cylContBtn = new JButton("Continue");
                JButton cylBackBtn = new JButton("Back");

                cylContBtn.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        String cylDiameterVal = cylDiameterTextarea.getText();
                        String cylHeightVal = cylHeightTextarea.getText();

                        selectedShape = new Cylinder(Integer.parseInt(cylDiameterVal), Integer.parseInt(cylHeightVal));

                        changePanel("");
                     }
                });
                cylBackBtn.addActionListener(backBtn());

                buttonPnl.add(cylContBtn);
                buttonPnl.add(cylBackBtn);

                out.add(cylTemp);
                break;
            case "Square":
            case "Rectangle":
                JPanel recTemp = new JPanel(new GridLayout(2,2));
                JLabel recLengthLabel = new JLabel("Length");
                JTextArea recLengthTextarea = new JTextArea();
                JLabel recWidthLabel = new JLabel("Width");
                JTextArea recWidthTextarea = new JTextArea();

                recTemp.add(recLengthLabel);
                recTemp.add(recLengthTextarea);
                recTemp.add(recWidthLabel);
                recTemp.add(recWidthTextarea);

                JButton recContBtn = new JButton("Continue");
                JButton recBackBtn = new JButton("Back");

                recContBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String recLengthVal = recLengthTextarea.getText();
                        String recWidthVal = recWidthTextarea.getText();

                        if (sel.equals("Rectangle")) {
                            selectedShape = new Rectangle(Integer.parseInt(recLengthVal), Integer.parseInt(recWidthVal));
                        } else {
                            selectedShape = new Square(Integer.parseInt(recLengthVal), Integer.parseInt(recWidthVal));
                        }

                        changePanel("");
                    }
                });
                recBackBtn.addActionListener(backBtn());

                buttonPnl.add(recContBtn);
                buttonPnl.add(recBackBtn);

                out.add(recTemp);
                break;
            case "Torus":
                JPanel torTemp = new JPanel(new GridLayout(2,2));
                JLabel torMinLabel = new JLabel("Minor Radius");
                JTextArea torMinTextarea = new JTextArea();
                JLabel torMaxLabel = new JLabel("Major Radius");
                JTextArea torMaxTextarea = new JTextArea();

                torTemp.add(torMaxLabel);
                torTemp.add(torMaxTextarea);
                torTemp.add(torMinLabel);
                torTemp.add(torMinTextarea);

                JButton torContBtn = new JButton("Continue");
                JButton torBackBtn = new JButton("Back");

                torContBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String torMaxVal = torMaxTextarea.getText();
                        String torMinVal = torMinTextarea.getText();

                        selectedShape = new Torus(Integer.parseInt(torMinVal), Integer.parseInt(torMaxVal));

                        changePanel("");
                    }
                });
                torBackBtn.addActionListener(backBtn());

                buttonPnl.add(torContBtn);
                buttonPnl.add(torBackBtn);

                out.add(torTemp);
                break;
            case "Triangle":
                JPanel triTemp = new JPanel(new GridLayout(2, 2));
                JLabel triHeightLabel = new JLabel("Height");
                JTextArea triHeighTextarea = new JTextArea();
                JLabel triBaseLabel = new JLabel("Base");
                JTextArea triBaseTextarea = new JTextArea();

                triTemp.add(triHeightLabel);
                triTemp.add(triHeighTextarea);
                triTemp.add(triBaseLabel);
                triTemp.add(triBaseTextarea);

                JButton triContBtn = new JButton("Continue");
                JButton triBackBtn = new JButton("Back");

                triContBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String triHeightVal = triHeighTextarea.getText();
                        String triBaseVal = triBaseTextarea.getText();

                        selectedShape = new Triangle(Integer.parseInt(triBaseVal), Integer.parseInt(triHeightVal));

                        changePanel("");
                    }
                });
                triBackBtn.addActionListener(backBtn());

                buttonPnl.add(triContBtn);
                buttonPnl.add(triBackBtn);

                out.add(triTemp);
                break;
            default:
                break;
        }

        this.currentPage = "selection";
        System.out.println("GUI:    CurrentPage: Selection");

        out.add(buttonPnl);
        return out;
    }

    private ActionListener backBtn() {
        ActionListener out = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Goto previous screen");
                frame.getContentPane().removeAll();
                frame.getContentPane().add(menu());
                frame.setVisible(true);
            }
        };
        return out;
    }

    private JPanel displayShape(Shape s) {
        JPanel out = new JPanel(new GridLayout(3, 1));

        String imgStr = String.valueOf(s.getTYPE().charAt(0)).toLowerCase() + s.getTYPE().substring(1) + ".png";

        ImageIcon img = new ImageIcon(getClass().getResource(imgStr));
        JLabel imgLabel = new JLabel(img);

        JLabel imgDescLabel = new JLabel(s.toString(), SwingConstants.CENTER);

        JButton newBtn = new JButton("New Shape");

        newBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel("");
            }
        });

        out.add(imgLabel);
        out.add(imgDescLabel);
        out.add(newBtn);

        this.currentPage = "display";
        System.out.println("GUI:    CurrentPage: Display");

        return out;
    }

    private void changePanel(String selection) {
        System.out.println("GUI: Changing to panel...");

        switch(this.currentPage) {
            case "menu":
                System.out.println("GUI: " + selection + " was selected!");
                frame.getContentPane().removeAll();
                frame.setVisible(true);
                frame.getContentPane().add(selection(selection));
                frame.setVisible(true);
                break;
            case "selection":
                System.out.println("GUI: displaying shape...");
                frame.getContentPane().removeAll();
                frame.getContentPane().add(displayShape(selectedShape));
                frame.setVisible(true);
                break;
            case "display":
                System.out.println("GUI: Going back to menu...");
                frame.getContentPane().removeAll();
                frame.getContentPane().add(menu());
                frame.setVisible(true);
            default:
                break;
        }
    }
}