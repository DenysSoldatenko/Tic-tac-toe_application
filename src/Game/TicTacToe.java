package Game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame("Game");
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel("Tic-Tac-Toe");
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    int[][] combinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        textField.setBackground(Color.decode("#000000"));
        textField.setForeground(Color.decode("#FFFFFF"));
        textField.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(textField);
        titlePanel.setBounds(0, 0, 500, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Comic Sans MS", Font.BOLD, 75));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : buttons) {
            if (e.getSource() == button && button.getText().isEmpty()) {
                button.setForeground(player1_turn ? Color.decode("#FC766A") : Color.decode("#5B84B1"));
                button.setText(player1_turn ? "X" : "O");
                player1_turn = !player1_turn;
                textField.setText(player1_turn ? "X turn" : "O turn");
                check();
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player1_turn = random.nextInt(2) == 0;
        textField.setText(player1_turn ? "X turn" : "O turn");
    }
    public void check() {
        int flag = 0;
        for (int[] combination : combinations) {
            String text = buttons[combination[0]].getText();
            if (text.equals("X") || text.equals("O")) {
                if (text.equals(buttons[combination[1]].getText()) &&
                        text.equals(buttons[combination[2]].getText())) {
                    winner(combination[0], combination[1], combination[2], text);
                    flag = 1;
                }
            }
        }
        if (flag == 0) draw();
    }
    public void winner(int a, int b, int c, String s) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        disableButtons();
        textField.setText(s + " wins");
    }
    public void draw() {
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            if (!buttons[i].getText().isEmpty()) flag++;
        }
        if (flag == 9) {
            disableButtons();
            textField.setText("Draw wins");
        }
    }
    public void disableButtons() {
        for (int i = 0; i < 9; i++) buttons[i].setEnabled(false);
    }
}