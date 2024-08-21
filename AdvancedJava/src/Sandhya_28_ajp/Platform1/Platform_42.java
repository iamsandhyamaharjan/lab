package Sandhya_28_ajp.Platform1;

import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.*;

public class Platform_42 extends JFrame {
    private JPanel buttonPanel;

    public Platform_42() {
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }
        
        add(buttonPanel);
        pack();
    }

    private void makeButton(String name, String className) {
        JButton jButton = new JButton(name);
        buttonPanel.add(jButton);

        jButton.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            JFrame frame = new Platform_42();
//            frame.setTitle("NotHelloWorld");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        });
//    }
}
