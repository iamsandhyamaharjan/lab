/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp.button;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Dell
 */
public class FrameTest {
   public static void main(String[] args) {
         EventQueue.invokeLater(()->{
        JFrame frame = new ButtonFrame_41();
        frame.setTitle("NotHelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        });
    }  
}
