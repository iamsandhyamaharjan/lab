//Implement a basic drawing application where the user can draw lines by clicking and
//dragging the mouse. Use MouseListener and MouseMotionListener to achieve this
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Question1 extends JFrame {
    private JPanel drawingPanel;
    private ArrayList<Line> lines = new ArrayList<>();
    private Point startPoint = null;

    public Question1() {
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Line line : lines) {
                    g.drawLine(line.start.x, line.start.y, line.end.x, line.end.y);
                }
            }
        };

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (startPoint != null) {
                    lines.add(new Line(startPoint, e.getPoint()));
                    startPoint = null;
                    repaint();
                }
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (startPoint != null) {
                    lines.add(new Line(startPoint, e.getPoint()));
                    startPoint = e.getPoint();
                    repaint();
                }
            }
        });

        add(drawingPanel);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Basic Drawing Application");
    }

    private static class Line {
        Point start, end;

        Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Question1().setVisible(true));
    }
}
