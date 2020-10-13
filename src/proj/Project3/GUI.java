/**
 * Filename: GUI.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swim app that displays traffic statistics.
 */

package proj.Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public GUI() {
        System.out.println("P3: Creating GUI ...");
        frame = new JFrame("Traffic Analyzer");
        frame.setSize(440, 290);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(2,1,10,10));

        String[] carColumnNames = {"Car", "Distance"};
        String[] lightsColumnNames = {"Light", "Color", "Distance"};

        Cars c1 = new Cars("Car1");
        road[0] = c1;
        Cars c2 = new Cars("Car2");
        road[1] = c2;

        carData = new Object[][] {
                {c1.getName(), c1.getDistance()},
                {c2.getName(), c2.getDistance()}
        };

        Lights l1 = new Lights("Light1", "1000");
        Lights l2 = new Lights("Light2", "2000");
        Lights l3 = new Lights("Light3", "3000");

        lightData = new Object[][] {
                {l1.getLightName(), l1.getColor(), l1.getDistance()},
                {l2.getLightName(), l2.getColor(), l2.getDistance()},
                {l3.getLightName(), l3.getColor(), l3.getDistance()},
        };

        JTable carTable = new JTable(carData, carColumnNames);
        JTable lightsTable = new JTable(lightData, lightsColumnNames);

        carTable.setPreferredScrollableViewportSize(new Dimension(200, 150));
        carTable.setFillsViewportHeight(true);
        lightsTable.setPreferredScrollableViewportSize(new Dimension(200, 150));
        lightsTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(carTable);
        JScrollPane sPane2 = new JScrollPane(lightsTable);

        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("start your engines!");
                startCars();
            }
        });
        JButton pauseBtn = new JButton("Pause");
        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pause car");
                pauseCars();
            }
        });
        JButton stopBtn = new JButton("Stop");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("stopping car");
                stopCars();
            }
        });
        JButton addCarBtn = new JButton("Add Car");
        addCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("adding car");
                addCar();
            }
        });

        JPanel topPnl = new JPanel();
        topPnl.add(scrollPane);
        topPnl.add(sPane2);

        JPanel btmPnl = new JPanel();
        btmPnl.add(startBtn);
        btmPnl.add(pauseBtn);
        btmPnl.add(stopBtn);
        btmPnl.add(addCarBtn);

        panel.add(topPnl);
        panel.add(btmPnl);

        frame.add(panel);
        System.out.println("P3: Displaying GUI");
        frame.setVisible(true);

        updateInterface();
    }

    JFrame frame;
    JPanel panel;
    Object[][] carData;
    Object[][] lightData;
    Cars[] road = new Cars[2];

    private void updateInterface() {
//        while(true) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Object[road.length] tempArr = new Object[road.length];
//
//            for(int i = 0; i < road.length; i++) {
//                String n = road[i].getName();
//                String d = road[i].getDistance();
//
//                Object[][] t = new Object[][]{
//                        {n,d}
//                };
//
////                tempArr[i][0] = t;
//            }
//
//            JTable tempTable = new JTable(tempArr, new String[] {"Car", "Distance"});
//            tempTable.setPreferredScrollableViewportSize(new Dimension(200, 150));
//            tempTable.setFillsViewportHeight(true);
//
//            JScrollPane jspTemp = new JScrollPane(tempTable);
//
//            JPanel pnlTemp = new JPanel();
//            pnlTemp.add(jspTemp);
//
//            frame.getContentPane().removeAll();
//            frame.setVisible(true);
//            frame.getContentPane().add(pnlTemp);
//            frame.setVisible(true);
//        }
    }

    public void addCar() {
        int cnt = this.carData.length + 1;
        Cars temp = new Cars("Car" + String.valueOf(cnt));
        Cars[] tempRoad = new Cars[this.road.length + 1];

        for (int i = 0; i < this.road.length; i++) {
            tempRoad[i] = this.road[i];
        }
        tempRoad[this.road.length] = temp;

        Object[][] tempArr = new Object[cnt][];

        for (int i = 0; i < this.carData.length; i++) {
            System.out.println("i = " + i);
            tempArr[i] = this.carData[i];
        }
        tempArr[cnt - 1] = new Object[]{temp.getName(), temp.getDistance()};

        this.carData = tempArr;
        this.road = tempRoad;
    }

    public void startCars() {
        for (int i = 0; i < road.length; i++) {
            road[i].ts.setPause(false);
        }
    }

    public void pauseCars() {
        for (int i = 0; i < road.length; i++) {
            road[i].ts.setPause(true);
        }
    }

    public void stopCars() {
        for (int i = 0; i < road.length; i++) {
            road[i].ts.setStop(true);
        }
    }
}
