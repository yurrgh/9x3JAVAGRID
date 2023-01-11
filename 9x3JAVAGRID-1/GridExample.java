import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridExample extends JFrame {
    private boolean[][] grid = new boolean[3][9];
    private JButton[][] squares = new JButton[3][9];
    private final int BUTTON_SIZE = 50;
    private final int SPACE_BETWEEN_BUTTONS = 10;

    public GridExample() {
        setSize(450, 400);
        setTitle("Grid Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 9, SPACE_BETWEEN_BUTTONS, SPACE_BETWEEN_BUTTONS));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                JButton square = new JButton();
                square.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
                square.setBackground(Color.RED);
                final int x = i;
                final int y = j;
                square.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        square.setBackground(Color.GREEN);
                        grid[x][y] = true;
                    }
                });
                squares[i][j] = square;
                panel.add(square);
            }
        }

        JButton endButton = new JButton("End");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (grid[i][j]) {
                            System.out.println("Square at (" + i + ", " + j + ") is green.");
                        }
                    }
                }
            }
        });

        add(panel);
        add(endButton, BorderLayout.SOUTH);
    }
}