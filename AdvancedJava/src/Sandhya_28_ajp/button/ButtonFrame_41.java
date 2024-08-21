/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp.button;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Dell
 */



 public class ButtonFrame_41 extends JFrame {
 
    private JPanel buttonPanel;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame_41() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        buttonPanel = new JPanel();

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);

        buttonPanel.add(redButton);

        add(buttonPanel);

        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

    }

    private class ColorAction implements ActionListener {

        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }

    }
    
 }

