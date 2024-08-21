/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp.adapter;
import java.awt.event.*;
/**
 *
 * @author Dell
 */
public class Terminator extends WindowAdapter {
    public void windowClosing(WindowEvent e ){
        System.out.println("system is closing");
                System.exit(0);
    }
}
//create a frame and attach(register) this Adapter class