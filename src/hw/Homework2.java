package hw;

import java.util.ArrayList;

public class Homework2 {
    ArrayList<hw2> list = new ArrayList<hw2>();

    @Override
    public String toString() {
        String out = "";
        for (hw2 x : list) {
            out += x.x + " ";
        };
        return out;
    }

    public static void main(String[] args) {
        Homework2 y = new Homework2();

        int[] v = {4,3,7,5,99,3};

        for (int m : v) {
            y.list.add(new hw2(m));
        }
        System.out.println(y.toString());
    }
}

class hw2 {
    int x;

    public hw2(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
