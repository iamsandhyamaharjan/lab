package Sandhya_28_ajp.Platform1;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Platform1Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new Platform_42();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
