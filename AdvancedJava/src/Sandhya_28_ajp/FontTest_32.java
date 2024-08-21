/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sandhya_28_ajp;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.font.*;
/**
 *
 * @author Dell
 */
public class FontTest_32 {
    public static void main(String[] args) {
         EventQueue.invokeLater(()->{
        JFrame frame = new NotHelloWorldFrame();
        frame.setTitle("NotHelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {

    public NotHelloWorldFrame() {

        add(new FontComponent());
        pack();
    }
}
 class FontComponent extends JComponent{
   public static final int DEFAULT_WIDTH =300;
public static final int DEFAULT_HEIGHT = 200;
public void paintComponent(Graphics g){
Graphics2D g2 = (Graphics2D) g;

String message = "Hello World";
Font f = new  Font("Serif",Font.BOLD,36);

g2.setFont(f);

FontRenderContext context = g2.getFontRenderContext();
Rectangle2D bounds =f.getStringBounds(message,context);


double x =(getWidth() - bounds.getWidth())/2;
double y = (getHeight()- bounds.getHeight())/2;

double ascent = -bounds.getY();
double baseY = y+ascent ;

g2.setPaint(Color.RED);
g2.drawString(message,(int)x,(int)baseY);
g2.setPaint(Color.RED);


g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));

Rectangle2D rect =new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
g2.draw(rect);


}
 
 public Dimension getPreferredSize(){
 return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
 }
 }