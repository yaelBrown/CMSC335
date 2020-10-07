package hw;

public class Homework4 {

    public static void main (String args []) throws InterruptedException {
        String [] sa = {"a", "X", "+", "."};
        for (String s: sa) {
            Runnable ps = new PrintChar (s, 200);
            Thread ts = new Thread(ps, s);
            Thread.sleep(500);
            ts.start();
        } // end for each character } // end main
    } // end class TaskThreadDemo

    static class PrintChar implements Runnable {
        String ch;
        int times;

        public PrintChar (String c, int n) {
            ch = c;
            times = n;
        } // end constructor

        public void run() {
            for (int i = 0; i < times; i++) {
                System.out.print (ch);
            } // end for loop
        } // end method run

    } // end class PrintChar
}
