/**
 * Filename: Cars.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swim app that displays traffic statistics.
 */

package proj.Project3;

public class Cars {
    public Cars(String n) {
        speed = 1;
        name = n;
        tThread.start();
    }

    private int speed;
    private String name;
    public TimeStamp ts = new TimeStamp();
    private Thread tThread = new Thread(ts);

    public String getDistance() {
        Long temp = ts.getTime() * 88L;

        if (temp > 5280L) {
            Long miles = temp / 5280L;
            String mOut;
            if (miles < 2) {
                mOut = miles.toString() + " mile ";
            } else {
                mOut = miles.toString() + " miles ";
            }

            Long feet = temp % 5280L;
            return mOut + "and " + feet.toString() + " feet";
        } else {
            return String.valueOf(ts.getTime() * 88L) + " Ft";
        }
    }

    public String getSpeed() {
        return String.valueOf(speed + " mph");
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
