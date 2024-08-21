
import javax.swing.*;
import java.awt.event.*;
import Sandhya_28_ajp.adapter.Terminator;  // Import the Terminator class

public class FrameWithTerminator_52 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Terminator Frame");

        frame.setSize(400, 300);

        frame.addWindowListener(new Terminator());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
