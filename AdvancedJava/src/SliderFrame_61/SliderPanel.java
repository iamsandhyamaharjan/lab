/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import SliderFrame_61.SliderFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Dell
 */
public class SliderPanel {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SliderFrame();
            frame.setTitle("Slider Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });    
    }
  
}
