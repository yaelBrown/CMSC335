package hw;

public class Homework1 {
//    int v = 12;
//
//    public void Homework1(int pV) {
//        v = pV;
//    }
//
//    public Homework1() {}
//
//    public int getV() {
//        return v;
//    }

    public static void main(String[] args) {
        Cookies m = new Cookies(23, true);

        System.out.println("m.getV() = " + m.getV());
    }
}

class Cookies {
    int v = 12;

    public Cookies(int c, boolean b) {
        this (c);
    }

    private Cookies(int z) {
        v = z;
    }

    public int getV() {
        return v;
    }
}
