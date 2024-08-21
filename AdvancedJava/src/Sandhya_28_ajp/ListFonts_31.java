/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp;
import java.awt.*;
/**
 *
 * @author Dell
 */
public class ListFonts_31 {
    public static void main(String[] args) {
        String[] fontNames =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        System.out.println("total fontNames"+ fontNames.length);
        for(String fontName:fontNames){
            System.out.println(fontName);
        }
               
    }
    
}
