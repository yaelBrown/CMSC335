package disc.w4;

import javax.swing.*;

public class DiscW4 {

    public DiscW4() {
        JFrame frame = new JFrame("Basic Swing GUI");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Basic Label");

        panel.add(label);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DiscW4 d = new DiscW4();
    }

}
