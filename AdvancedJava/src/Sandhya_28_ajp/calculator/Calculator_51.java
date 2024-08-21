import javax.swing.*;
import java.awt.event.*;
import Sandhya_28_ajp.calculator.CalculatorPanel;  // Import the Terminator class
import java.awt.EventQueue;


public class Calculator_51 {
    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
        
         // Create a new JFrame
        JFrame frame = new JFrame("Terminator Frame");

        // Set the size of the frame
        frame.setSize(400, 300);

        // Add the Terminator as a window listener
        frame.add(new CalculatorPanel());

        // Set the default close operation (optional, as the Terminator will handle it)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to be visible
        frame.setVisible(true);
        
        
        });
        
       
    }
}
