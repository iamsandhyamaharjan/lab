import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Question3 extends JFrame {
    private JPanel drawingPanel;
    private String currentShape = "Line";
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Question3() {
        // Create the drawing panel
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape shape : shapes) {
                    shape.draw(g);
                }
            }
        };

        // Create the button panel and buttons
        JPanel buttonPanel = new JPanel();
        JButton lineButton = new JButton("Line");
        JButton rectangleButton = new JButton("Rectangle");
        JButton circleButton = new JButton("Circle");

        // Add action listeners to the buttons
        lineButton.addActionListener(e -> {
            currentShape = "Line";
            System.out.println("Selected shape: Line");
        });
        rectangleButton.addActionListener(e -> {
            currentShape = "Rectangle";
            System.out.println("Selected shape: Rectangle");
        });
        circleButton.addActionListener(e -> {
            currentShape = "Circle";
            System.out.println("Selected shape: Circle");
        });

        // Add buttons to the button panel
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(circleButton);

        // Add mouse listener to the drawing panel
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = e.getPoint();
                System.out.println("Mouse clicked at: " + clickPoint);
                switch (currentShape) {
                    case "Line":
                        shapes.add(new Line(clickPoint));
                        System.out.println("Added Line shape");
                        break;
                    case "Rectangle":
                        shapes.add(new Rectangle(clickPoint));
                        System.out.println("Added Rectangle shape");
                        break;
                    case "Circle":
                        shapes.add(new Circle(clickPoint));
                        System.out.println("Added Circle shape");
                        break;
                }
                drawingPanel.repaint();
            }
        });

        // Set the layout and add components to the frame
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Shape Drawing Application");
    }

    // Shape interface
    private interface Shape {
        void draw(Graphics g);
    }

    // Line shape implementation with a fixed size
    private static class Line implements Shape {
        Point point;

        Line(Point point) {
            this.point = point;
        }

        @Override
        public void draw(Graphics g) {
            g.drawLine(point.x, point.y, point.x + 50, point.y);  // Drawing a line of fixed length 50
        }
    }

    // Rectangle shape implementation with a fixed size
    private static class Rectangle implements Shape {
        Point point;

        Rectangle(Point point) {
            this.point = point;
        }

        @Override
        public void draw(Graphics g) {
            int width = 50;
            int height = 30;
            g.drawRect(point.x, point.y, width, height);
        }
    }

    // Circle shape implementation with a fixed size
    private static class Circle implements Shape {
        Point point;

        Circle(Point point) {
            this.point = point;
        }

        @Override
        public void draw(Graphics g) {
            int radius = 25;
            g.drawOval(point.x - radius, point.y - radius, radius * 2, radius * 2);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Question3().setVisible(true));
    }
}
