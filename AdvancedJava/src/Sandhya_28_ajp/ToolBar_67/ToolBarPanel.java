/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp.ToolBar_67;

import Sandhya_28_ajp.ToolBarPanel.ToolBarFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Dell
 */
public class ToolBarPanel {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ToolBarFrame();
            frame.setTitle("ToolBarFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });    
    }
  
}
