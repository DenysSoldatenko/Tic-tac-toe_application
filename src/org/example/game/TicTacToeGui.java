package org.example.game;

import static java.awt.BorderLayout.NORTH;
import static java.awt.Color.GREEN;
import static java.awt.Color.decode;
import static java.awt.Font.BOLD;
import static java.lang.Thread.sleep;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeGui implements ActionListener {
  JFrame frame = new JFrame("Game");
  JPanel titlePanel = new JPanel();
  JPanel buttonPanel = new JPanel();
  JLabel textField = new JLabel("Tic-Tac-Toe");
  JButton[] buttons = new JButton[9];

  boolean playerTurn;
  int[][] combinations = {
    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
    {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
  };

  public TicTacToeGui() {
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.getContentPane().setBackground(new Color(50, 50, 50));
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    textField.setBackground(decode("#000000"));
    textField.setForeground(decode("#FFFFFF"));
    textField.setFont(new Font("Comic Sans MS", BOLD, 50));
    textField.setHorizontalAlignment(CENTER);
    textField.setOpaque(true);

    titlePanel.setLayout(new BorderLayout());
    titlePanel.add(textField);
    titlePanel.setBounds(0, 0, 500, 100);

    buttonPanel.setLayout(new GridLayout(3, 3));

    for (int i = 0; i < 9; i++) {
      buttons[i] = new JButton();
      buttons[i].setFont(new Font("Comic Sans MS", BOLD, 75));
      buttons[i].setFocusable(false);
      buttons[i].addActionListener(this);
      buttonPanel.add(buttons[i]);
    }

    frame.add(titlePanel, NORTH);
    frame.add(buttonPanel);
    firstTurn();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (JButton button : buttons) {
      if (e.getSource() == button && button.getText().isEmpty()) {
        button.setForeground(playerTurn ? decode("#FC766A") : decode("#5B84B1"));
        button.setText(playerTurn ? "X" : "O");
        playerTurn = !playerTurn;
        textField.setText(playerTurn ? "X turn" : "O turn");
        check();
      }
    }
  }

  public void firstTurn() {
    try {
      sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    playerTurn = new Random().nextInt(2) == 0;
    textField.setText(playerTurn ? "X turn" : "O turn");
  }

  public void check() {
    int flag = 0;
    for (int[] combination : combinations) {
      String text = buttons[combination[0]].getText();
      if (text.equals("X") || text.equals("O")) {
        if (text.equals(buttons[combination[1]].getText())
            && text.equals(buttons[combination[2]].getText())) {
          winner(combination[0], combination[1], combination[2], text);
          flag = 1;
        }
      }
    }
    if (flag == 0) {
      draw();
    }
  }

  public void winner(int a, int b, int c, String s) {
    buttons[a].setBackground(GREEN);
    buttons[b].setBackground(GREEN);
    buttons[c].setBackground(GREEN);
    disableButtons();
    textField.setText(s + " wins");
  }

  public void draw() {
    int flag = 0;
    for (int i = 0; i < 9; i++) {
      if (!buttons[i].getText().isEmpty()) {
        flag++;
      }
    }
    if (flag == 9) {
      disableButtons();
      textField.setText("Draw wins");
    }
  }

  public void disableButtons() {
    for (int i = 0; i < 9; i++) {
      buttons[i].setEnabled(false);
    }
  }
}
