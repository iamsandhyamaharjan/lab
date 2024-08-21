/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp;
import javax.swing.*;
import java.awt.*;

public class NotHelloWorld_21 {
    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
        JFrame frame = new NotHelloWorldFrame();
        frame.setTitle("NotHelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {

    public NotHelloWorldFrame() {

        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawString("Not Hello world", MESSAGE_X, MESSAGE_Y);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    }

}
