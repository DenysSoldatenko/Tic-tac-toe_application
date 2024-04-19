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
import lombok.SneakyThrows;

/**
 * GUI for the Tic-Tac-Toe game.
 *
 * <p>Sets up the game board and handles game logic such as player turns,
 * checking for wins or draws, and updating the UI.
 */
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

  /**
   * Initializes the Tic-Tac-Toe GUI.
   *
   * <p>Sets up the game board, UI components, and starts the first turn.
   */
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
        checkGameStatus();
      }
    }
  }

  /**
   * Sets the initial turn for the first player after a delay.
   *
   * <p>Randomly decides which player (X or O) goes first and updates the UI accordingly.
   */
  @SneakyThrows
  public void firstTurn() {
    sleep(2000);
    playerTurn = new Random().nextInt(2) == 0;
    textField.setText(playerTurn ? "X turn" : "O turn");
  }

  /**
   * Checks the current state of the game to determine if there is a highlightWinningCombination or a isDraw.
   *
   * <p>Updates the UI and disables buttons if a win or isDraw is detected.
   */
  public void checkGameStatus() {
    int flag = 0;
    for (int[] combination : combinations) {
      String text = buttons[combination[0]].getText();
      if (text.equals("X") || text.equals("O")) {
        if (text.equals(buttons[combination[1]].getText())
            && text.equals(buttons[combination[2]].getText())) {
          highlightWinningCombination(combination[0], combination[1], combination[2], text);
          flag = 1;
        }
      }
    }
    if (flag == 0) {
      isDraw();
    }
  }

  /**
   * Highlights the winning combination and updates the UI to show the highlightWinningCombination.
   *
   * <p>Disables all buttons to prevent further input.
   *
   * @param a The index of the first button in the winning combination.
   * @param b The index of the second button in the winning combination.
   * @param c The index of the third button in the winning combination.
   * @param s The symbol of the highlightWinningCombination ("X" or "O").
   */
  public void highlightWinningCombination(int a, int b, int c, String s) {
    buttons[a].setBackground(GREEN);
    buttons[b].setBackground(GREEN);
    buttons[c].setBackground(GREEN);
    disableButtons();
    textField.setText(s + " wins");
  }

  /**
   * Checks if the game is a isDraw.
   *
   * <p>Updates the UI and disables all buttons if the game is a isDraw.
   */
  public void isDraw() {
    int flag = 0;
    for (int i = 0; i < 9; i++) {
      if (!buttons[i].getText().isEmpty()) {
        flag++;
      }
    }
    if (flag == 9) {
      disableButtons();
      textField.setText("Draw");
    }
  }

  /**
   * Disables all game buttons.
   *
   * <p>Prevents further interaction with the game board after a win or isDraw.
   */
  public void disableButtons() {
    for (int i = 0; i < 9; i++) {
      buttons[i].setEnabled(false);
    }
  }
}
