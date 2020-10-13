/**
 * Filename: TimeStamp.java
 * Author: Yael Brown
 * Date: 9/14/2020
 * Brief Purpose of the Program:  Java Swim app that displays traffic statistics.
 */

package proj.Project3;

public class TimeStamp implements Runnable {
    public TimeStamp() {}

    private Long time = 0L;
    private boolean stop = false;
    private boolean pause = false;

    @Override
    public void run() {
        while(stop == false) {
            while(pause == false) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println(time);
                } catch(InterruptedException e) {
                    System.out.println("Something went wrong: " + e);
                }

                if (stop == true) {
                    break;
                }
            }
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setPause(boolean pause) {
//        if (pause == false) {
//            this.pause = pause;
//            this.run();
//        } else {
//            this.pause = pause;
//        }
        this.pause = pause;
    }

    public Long getTime() {
        return time;
    }
}
