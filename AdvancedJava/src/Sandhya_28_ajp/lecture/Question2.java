//Create a JFrame with a JPanel. Change the background color of the panel when the
//mouse enters it and change it back when the mouse exits. Use a MouseAdapter for this task.
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Question2 extends JFrame {
    private JPanel colorPanel;

    public Question2() {
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);
        colorPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                colorPanel.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                colorPanel.setBackground(Color.WHITE);
            }
        });

        add(colorPanel);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mouse Event Demo");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Question2().setVisible(true));
    }
}
