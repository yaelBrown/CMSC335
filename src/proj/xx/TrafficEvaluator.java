package TrafficEvaluator;

/*
File name: TrafficEvaluator.java
Date: 11 Aug 20
Author: Shaun Reid
Purpose: The TrafficEvaluator class calls the main GUI and holds all of the inner classes that represent the thread objects.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;



public class TrafficEvaluator {

    //Declares all of the GUI components and makes them available to the threads for update.
    static JButton startBtn = new JButton("Start");
    static JButton stopBtn = new JButton("Stop");
    static JButton pauseBtn = new JButton("Pause");
    static JButton continueBtn = new JButton("Continue");
    static JButton addCarBtn = new JButton("Add Car");
    static JButton addIntersectionBtn = new JButton("Add Intersection");
    static JLabel timeLbl = new JLabel("##:##:##");
    static String [][] carMockData;
    static String [] carColumnNames = {"Car", "Position(meters)", "Speed(Km/h)"};
    static String [][] lightMockData;
    static String [] lightColumnNames = {"Light", "Status", "X Pos(meters)"};
    static DefaultTableModel lightModel = new DefaultTableModel(lightMockData, lightColumnNames);
    static DefaultTableModel carModel = new DefaultTableModel(carMockData, carColumnNames);
    static JTable carTbl = new JTable(carModel);
    static JTable lightTbl = new JTable(lightModel);
    static JTextArea timeTxtArea = new JTextArea();
    static JScrollPane carPane = new JScrollPane(carTbl);
    static JScrollPane lightPane = new JScrollPane(lightTbl);
    static JScrollPane timePane = new JScrollPane(timeTxtArea);

    //Variables used for the traffic light threads
    int lightCounter = 0;
    int lightXPos = 1000;
    TrafficLight[] lights = new TrafficLight[15];

    //Variables used for the car threads
    int carCounter = 0;
    Car[] cars = new Car[15];

    //Main method that calls the TrafficEvaluator constructor
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TrafficEvaluator();
            }
        });

    }

    //Calls the build GUI method
    TrafficEvaluator(){
        buildGUI();
    }

    //Builds the GUI
    public void buildGUI() {

        //Declaring the time stamp object and thread. No need to create a separate inner class to create the time stamp because there is only one.
        TimeStamp time = new TimeStamp();
        Thread timeThread = new Thread(time);

        //Creating the operation button panel
        JPanel opPanel = new JPanel(new FlowLayout());
        stopBtn.setEnabled(false);
        pauseBtn.setEnabled(false);
        continueBtn.setEnabled(false);
        opPanel.add(startBtn);
        opPanel.add(stopBtn);
        opPanel.add(pauseBtn);
        opPanel.add(continueBtn);
        opPanel.setBorder(BorderFactory.createTitledBorder("Operational Buttons"));

        //Declaring the add car and intersection panel
        JPanel addPanel = new JPanel(new FlowLayout());
        addCarBtn.setEnabled(false);
        addIntersectionBtn.setEnabled(false);
        addPanel.add(addCarBtn);
        addPanel.add(addIntersectionBtn);
        addPanel.setBorder(BorderFactory.createTitledBorder("Add Components"));

        //Creating the table panel
        JPanel tblPanel = new JPanel(new BorderLayout());
        carTbl.setPreferredScrollableViewportSize(carTbl.getPreferredSize());
        carPane.getPreferredSize();
        lightTbl.setPreferredScrollableViewportSize(lightTbl.getPreferredSize());
        lightPane.getPreferredSize();
        tblPanel.add(carPane, BorderLayout.CENTER);
        tblPanel.add(lightPane, BorderLayout.EAST);
        tblPanel.setBorder(BorderFactory.createTitledBorder("Car and Traffic Light Info"));

        //Creating the time panel
        JPanel timePanel = new JPanel(new FlowLayout());
        timePanel.add(timeLbl);
        timePanel.setBorder(BorderFactory.createTitledBorder("Time"));

        //Creating the main frame window
        JFrame mainFrame = new JFrame("Traffic Evaluator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(opPanel, BorderLayout.NORTH);
        mainFrame.add(addPanel, BorderLayout.SOUTH);
        mainFrame.add(tblPanel, BorderLayout.CENTER);
        mainFrame.add(timePanel, BorderLayout.EAST);
        mainFrame.setSize(900, 350);
        mainFrame.setVisible(true);

        //Fired when the start button is pressed
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //starting the time thread
                timeThread.start();

                //Creates three different traffic light threads when the start button is pressed
                lights[lightCounter] = new TrafficLight(Integer.toString(lightCounter + 1), lightXPos);
                new AddTrafficLight(Integer.toString(lightCounter + 1), lights[lightCounter], lightXPos);
                lightCounter++;
                lightXPos = lightXPos + 1000;

                lights[lightCounter] = new TrafficLight(Integer.toString(lightCounter + 1), lightXPos);
                new AddTrafficLight(Integer.toString(lightCounter + 1), lights[lightCounter], lightXPos);
                lightCounter++;
                lightXPos = lightXPos + 1000;

                lights[lightCounter] = new TrafficLight(Integer.toString(lightCounter + 1), lightXPos);
                new AddTrafficLight(Integer.toString(lightCounter + 1), lights[lightCounter], lightXPos);
                lightCounter++;
                lightXPos = lightXPos + 1000;

                //Creates three different cars at different speeds, when the start button is pressed
                cars[carCounter] = new Car(Integer.toString(carCounter + 1));
                new AddCar(Integer.toString(carCounter + 1), cars[carCounter]);
                carCounter++;

                cars[carCounter] = new Car(Integer.toString(carCounter + 1));
                new AddCar(Integer.toString(carCounter + 1), cars[carCounter]);
                carCounter++;

                cars[carCounter] = new Car(Integer.toString(carCounter + 1));
                new AddCar(Integer.toString(carCounter + 1), cars[carCounter]);
                carCounter++;

                //Controls the state of the rest of the buttons when the start button is pressed
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                stopBtn.setEnabled(true);
                addCarBtn.setEnabled(true);
                addIntersectionBtn.setEnabled(true);

            }
        });

        //Fired when the stop button is pressed
        stopBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time.stop();

                //Stops all the traffic lights
                for(int i = 0; i < lightCounter; i++) {
                    lights[i].stop();
                }

                //Stops all the cars
                for(int i = 0; i < carCounter; i++) {
                    cars[i].stop();
                }

                pauseBtn.setEnabled(false);
                addCarBtn.setEnabled(false);
                addIntersectionBtn.setEnabled(false);
                stopBtn.setEnabled(false);
            }
        });

        //Fired when the pause button is pressed
        pauseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Pauses the time stamps
                time.pause();

                //Controls the other buttons
                pauseBtn.setEnabled(false);
                continueBtn.setEnabled(true);

                //Pauses all of the traffic lights
                for(int i = 0; i < lightCounter; i++) {
                    lights[i].pause();
                }

                //Pauses all of the cars
                for(int i = 0; i < carCounter; i++) {
                    cars[i].pause();
                }
            }
        });

        //Fires when the continue button is pressed
        continueBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Resumes the time
                time.resume();

                //Controls the other buttons
                continueBtn.setEnabled(false);
                pauseBtn.setEnabled(true);

                //Resumes the traffic lights after being paused
                for(int i = 0; i < lightCounter; i++) {
                    lights[i].resume();
                }

                //Resumes the cars after being paused
                for(int i = 0; i < carCounter; i++) {
                    cars[i].resume();
                }

            }
        });

        //Fired when the add car button is pressed
        addCarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cars[carCounter] = new Car(Integer.toString(carCounter + 1));
                new AddCar(Integer.toString(carCounter + 1), cars[carCounter]);
                carCounter++;

            }
        });

        //Fired when the add Intersection button is pressed
        addIntersectionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lights[lightCounter] = new TrafficLight(Integer.toString(lightCounter + 1), lightXPos);
                new AddTrafficLight(Integer.toString(lightCounter + 1), lights[lightCounter], lightXPos);
                lightCounter++;
                lightXPos = lightXPos + 1000;
            }
        });
    }

    //Adds traffic light objects and threads
    class AddTrafficLight {
        Thread light;
        String name;
        int position;

        AddTrafficLight(String threadname, TrafficLight tLight, int tLitePos){
            name = threadname;
            position = tLitePos;
            light = new Thread(tLight, name);
            light.start();
        }

    }

    //Adds car objects and lights
    class AddCar {

        Thread car;
        String name;

        AddCar(String carThreadName, Car carOb){
            name = carThreadName;
            car = new Thread(carOb, name);
            car.start();
        }
    }

    //Time stamp inner class that runs the time stamp and updates the GUI objects
    class TimeStamp implements Runnable {

        private String currentTime = "";
        private boolean stopTm = false;
        private boolean pauseTm = false;

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        public TimeStamp() {

        }

        //Runs the time stamp running clock
        synchronized public void run() {

            while(stopTm == false) {

                while(pauseTm == false) {

                    try {
                        Date date = new Date();
                        currentTime = new String(formatter.format(date));
                        Thread.sleep(1000);

                        timeLbl.setText(currentTime);

                    } catch(InterruptedException e) {
                        System.out.println("Thread Interrupted");
                    }
                    if(stopTm == true) {
                        break;
                    }
                }

                System.out.println("");
            }
        }

        //Pauses the time stamps
        public void pause() {
            pauseTm = true;

        }

        //Resumes the time stamps
        public void resume() {
            pauseTm = false;
        }

        //Stops the time stamps
        public void stop() {
            stopTm = true;
        }

    }

    //Enum that represents the traffic light colors
    enum LightColor{
        RED, GREEN, YELLOW
    }

    //Traffic light inner class that run each traffic light thread and updates the GUI
    class TrafficLight implements Runnable{


        private LightColor lightColor;
        private boolean stop = false;
        private boolean pause = false;
        private boolean changed = false;
        private String lightName;
        private int xPosition;
        private int row;

        TrafficLight(String name, int xPos){
            lightColor = LightColor.RED;
            lightName = "Light" + name;
            xPosition = xPos;
            lightModel.addRow(new Object[] {lightName, lightColor, xPosition});
            row = lightModel.getRowCount()-1;
        }

        //Runs the traffic lights
        synchronized public void run() {

            while(stop == false) {
                while(pause == false) {
                    lightModel.setValueAt(lightColor, row, 1);
                    changed = false;
                    try {
                        switch(lightColor) {
                            case GREEN:
                                Thread.sleep(10000);
                                break;
                            case YELLOW:
                                Thread.sleep(2000);
                                break;
                            case RED:
                                Thread.sleep(12000);
                                break;
                        }
                    } catch(InterruptedException e) {
                        System.out.println(e);
                    }

                    if(stop == true) {
                        break;
                    }
                    //Calls change color
                    changeColor();
                }
            }

        }

        //Changes the color of the traffic light
        synchronized void changeColor() {
            switch(lightColor) {
                case RED:
                    lightColor = LightColor.GREEN;
                    break;
                case YELLOW:
                    lightColor = LightColor.RED;
                    break;
                case GREEN:
                    lightColor = LightColor.YELLOW;
            }

            changed = true;

        }

        //Returns the light color
        LightColor getColor() {
            return lightColor;
        }

        //Returns the light position
        int getLightPos() {
            return xPosition;
        }

        //Returns if the light has changed
        boolean getChangedStatus() {
            return changed;
        }

        //Stops the traffic lights
        public void stop() {
            stop = true;
        }

        //Pauses the traffic lights
        public void pause() {
            pause = true;
        }

        //Resumes the traffic lights
        public void resume() {
            pause = false;
        }
    }

    //Car inner class that represents each car
    class Car implements Runnable {

        private String carName;
        private int carXPos = 0;
        private final int carYPos = 0;
        private String position;
        private int speed;
        private int rate;
        private boolean stop;
        private boolean pause;
        private int row;


        Car(String name){
            carName = "Car" + name;
            position = "(" + carXPos + ", " + carYPos + ")";
            calcSpeed();
            carModel.addRow(new Object[] {carName, position, Integer.toString(speed)});
            row = carModel.getRowCount()-1;
        }

        //Runs each car
        synchronized public void run() {

            while(stop == false) {
                while(pause == false) {
                    position = "(" + carXPos + ", " + carYPos + ")";
                    carXPos++;
                    try {
                        Thread.sleep(rate);
                    } catch(InterruptedException e) {
                        System.out.println("Car Interrupted");
                    }

                    //Presents the car position on the GUI table
                    carModel.setValueAt(position, row, 1);

                    //Checks if the car is at a multiple of 1000
                    if(carXPos%1000 == 0) {

                        //Loop that checks for the traffic light positions
                        for(int i = 0; i <= lights.length - 1; i++) {

                            //Checks that the car position and light position are the same
                            if(carXPos == lights[i].getLightPos()) {

                                //Checks the traffic lights color and stops the car if the light is red
                                if(lights[i].getColor() == LightColor.RED) {

                                    //Loop that waits for the light to change
                                    while(lights[i].getChangedStatus() == false) {
                                        System.out.println("");
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    if(stop == true) {
                        break;
                    }
                }
                System.out.println("");
            }
        }

        //Returns one of three randomly selected speeds
        public void calcSpeed() {
            Random rand = new Random();
            int flag = rand.nextInt(3);

            if(flag == 0) {
                speed = 36;
                rate = 100;
            } else if(flag == 1) {
                speed = 54;
                rate = 75;
            } else if(flag == 2) {
                speed = 72;
                rate = 50;
            }
        }

        //Stops the car
        public void stop() {
            stop = true;
        }

        //Pauses the car
        public void pause() {
            pause = true;
        }

        //Resumes the car after paused
        public void resume() {
            pause = false;
        }
    }
}