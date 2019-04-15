package chapter19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FillDemo extends JFrame implements ActionListener {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    public static final int FILL_WIDTH = 300;
    public static final int FILL_HEIGHT = 100;
    public static final int CIRCLE_SIZE = 10;
    public static final int PAUSE = 100;

    private JPanel box;



    public static void main(String[] args) {
        FillDemo gui = new FillDemo();
        gui.setVisible(true);
    }

    public FillDemo(){
        setSize(WIDTH, HEIGHT);
        setTitle("FillDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        box = new JPanel();
        add(box, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton startButton = new JButton("Start");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        fill();
    }

    private void fill() {
        Graphics g = box.getGraphics();
        for (int y = 0; y < FILL_HEIGHT; y += CIRCLE_SIZE) {
            for (int x = 0; x < FILL_WIDTH; x += CIRCLE_SIZE) {
                g.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
                doNothing(PAUSE);
            }
        }
    }

    private void doNothing(int milliseconds) {
        try{
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error");
            System.exit(0);
        }
    }
}
