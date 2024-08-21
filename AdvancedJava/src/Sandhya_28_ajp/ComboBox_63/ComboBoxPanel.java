package Sandhya_28_ajp.ComboBox_63;

import javax.swing.*;
import java.awt.event.*;
import Sandhya_28_ajp.ComboBox_63.ComboBoxFrame;  // Import the Terminator class
import java.awt.EventQueue;


public class ComboBoxPanel {
    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
        
     EventQueue.invokeLater(() -> {
            JFrame frame = new ComboBoxFrame();
            frame.setTitle("ComboBox");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        
        
        });
        
       
    }
}
