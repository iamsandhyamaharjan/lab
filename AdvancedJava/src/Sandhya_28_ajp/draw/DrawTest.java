/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp.draw;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class DrawTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {

    public DrawFrame() {
        add(new DrawComponent());
        pack();

    }
}

class DrawComponent extends JComponent {

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);
        Ellipse2D ellipse =new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);
        
        g2.draw(new Line2D.Double(leftX,topY,leftX+width,topY+height));
        
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius =150;
        
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);

    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    }
}
