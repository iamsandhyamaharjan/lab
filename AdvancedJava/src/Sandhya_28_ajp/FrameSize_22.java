
package Sandhya_28_ajp;
import java.awt.*;
import javax.swing.*;


public class FrameSize_22 {
     public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Frame with Icon Using Toolkit");

        // Get the screen size using Toolkit
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Calculate a good frame size (e.g., half of the screen size)
        int frameWidth = screenSize.width / 2;
        int frameHeight = screenSize.height / 2;
        frame.setSize(frameWidth, frameHeight);

        // Center the frame on the screen
        int x = (screenSize.width - frameWidth) / 2;
        int y = (screenSize.height - frameHeight) / 2;
        frame.setLocation(x, y);

        // Set an icon image for the frame using Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon icon = new ImageIcon(toolkit.getImage("icon.jpeg")); // Replace with your icon image path
        frame.setIconImage(icon.getImage());

        // Optionally add a label to display some text
        JLabel label = new JLabel("This is a frame with an icon and good size.", JLabel.CENTER);
        frame.add(label);

        // Set the default close operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
}
