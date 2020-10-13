/**
 * Filename: Lights.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swim app that displays traffic statistics.
 */

package proj.Project3;

public class Lights {
    public Lights(String n, String d) {
        lightName = n;
        color = "GREEN";
        distance = d;

//        lightLogic();
    }

    private String lightName;
    private String color;
    private String distance;
    private TimeStamp ts = new TimeStamp();
    private Thread lThread = new Thread(ts);

    private void lightLogic() {
        lThread.start();
        while(true) {
            if (ts.getTime().equals(2L)) {
                setColor("YELLOW");
                System.out.println(getColor());
            }

            if (ts.getTime().equals(40L)) {
                setColor("RED");
                System.out.println(getColor());
            }

            if (ts.getTime().equals(60)) {
                setColor("GREEN");
                System.out.println(getColor());
            }
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLightName() {
        return lightName;
    }

    public String getColor() {
        return color;
    }

    public String getDistance() {
        return distance;
    }
}
