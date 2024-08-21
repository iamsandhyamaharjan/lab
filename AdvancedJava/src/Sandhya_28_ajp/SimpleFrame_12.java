


package Sandhya_28_ajp;
import java.awt.*;
import javax.swing.*;
public class SimpleFrame_12 {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
        SimpleFrameTest frame = new SimpleFrameTest();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    });
    }
}
class SimpleFrameTest extends JFrame{
    private final static int DEFAULT_WIDTH=300;
        private final static int DEFAULT_HEIGHT=300;
        public SimpleFrameTest(){
            
            setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        }

}
